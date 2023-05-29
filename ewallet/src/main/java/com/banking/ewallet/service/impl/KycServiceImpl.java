package com.banking.ewallet.service.impl;

import com.banking.core.dto.api.ResponseCode;
import com.banking.core.dto.api.ResponseDescription;
import com.banking.core.dto.kyc.KycDto;
import com.banking.core.dto.transaction.TranType;
import com.banking.core.exception.TransactionException;
import com.banking.ewallet.model.*;
import com.banking.ewallet.repository.*;
import com.banking.ewallet.service.iface.KycService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class KycServiceImpl implements KycService {

    private final CustomerRepository customerRepository;
    private final AccountTypeRepository accountTypeRepository;
    private final AccountRepository accountRepository;
    private final CustomerTypeRepository customerTypeRepository;
    private final BranchRepository branchRepository;
    private final WalletConfigRepository walletConfigRepository;
    private final CurrencyRepository currencyRepository;
    private final CardRepository cardRepository;
    private static final String ACCOUNT = "ACCOUNT";
    private static final String DISABLED = "DISABLED";
    private static final String CARD_NOT_FOUND = "Card not found";
    private static final String CUSTOMER_NOT_FOUND = "Customer not found";
    private static final String ACCOUNT_NOT_FOUND = "Account not found";

    private KycDto createNewCustomer(KycDto kycDto) {
        Optional<Customer> customer = customerRepository.findFirstByNationalId(kycDto.getNationalId());
        if (customer.isPresent()) {
            throw new TransactionException("Customer already exists", kycDto);
        }
        WalletConfig walletConfig = walletConfigRepository.findAll().stream().findFirst()
                .orElseThrow(() -> new TransactionException("No configurations found", kycDto));
        AccountType accountType = accountTypeRepository.findById(kycDto.getAccountTypeId())
                .orElseThrow(() -> new TransactionException("Account type not found", kycDto));
        Branch branch = branchRepository.findById(kycDto.getBranchId())
                .orElseThrow(() -> new TransactionException("Branch not found", kycDto));
        Currency currency = currencyRepository.findById(kycDto.getCurrencyId())
                .orElseThrow(() -> new TransactionException("Currency not found", kycDto));
        CustomerType customerType = customerTypeRepository.findById(kycDto.getCustomerTypeId())
                .orElseThrow(() -> new TransactionException("Customer type not found", kycDto));
        Customer newCustomer = Customer
                .builder()
                .customerType(customerType)
                .accounts(null)
                .branch(branch)
                .designation("CUSTOMER")
                .email(kycDto.getEmail())
                .surname(kycDto.getLastName())
                .msisdn(kycDto.getMsisdn())
                .name(kycDto.getFirstName())
                .status("PENDING_APPROVAL")
                .nationalId(kycDto.getNationalId())
                .title(kycDto.getTitle())
                .dob(kycDto.getDob())
                .address(kycDto.getAddress())
                .build();
        customerRepository.saveAndFlush(newCustomer);

        Account account = Account
                .builder()
                .currency(currency.getName())
                .number(generateAccountNumber(branch, walletConfig, currency.getCode()))
                .customer(newCustomer)
                .accountType(accountType)
                .status("ACTIVE")
                .build();
        accountRepository.save(account);

        kycDto.setResponseCode(ResponseCode.SUCCESSFUL);
        kycDto.setResponseDescription(ResponseDescription.SUCCESSFUL);
        kycDto.getStructureData().put(ACCOUNT, account);
        return kycDto;
    }

    private KycDto disableCustomer(KycDto kycDto) {
        Customer customer = customerRepository.findById(kycDto.getCustomerId())
                .orElseThrow(() -> new TransactionException(CUSTOMER_NOT_FOUND, kycDto));
        customer.setStatus(DISABLED);
        customerRepository.save(customer);

        kycDto.setResponseCode(ResponseCode.SUCCESSFUL);
        kycDto.setResponseDescription(ResponseDescription.SUCCESSFUL);
        return kycDto;
    }

    private KycDto createNewAccount(KycDto kycDto) {
        Currency currency = currencyRepository.findById(kycDto.getCurrencyId())
                .orElseThrow(() -> new TransactionException("Currency not found", kycDto));
        WalletConfig walletConfig = walletConfigRepository.findAll().stream().findFirst()
                .orElseThrow(() -> new TransactionException("No configurations found", kycDto));
        AccountType accountType = accountTypeRepository.findById(kycDto.getAccountTypeId())
                .orElseThrow(() -> new TransactionException("Account type not found", kycDto));
        Customer customer = customerRepository.findById(kycDto.getCustomerId())
                .orElseThrow(() -> new TransactionException(CUSTOMER_NOT_FOUND, kycDto));
        List<Account> accounts = accountRepository.findByAccountTypeAndCustomer(accountType, customer);
        if (!accounts.isEmpty()) {
            accounts.forEach((account -> {
                if (account.getAccountType().equals(accountType)) {
                    throw new TransactionException("Account with the same account type already exists", kycDto);
                }
            }));
        }
        Account account = Account
                .builder()
                .currency(currency.getName())
                .number(generateAccountNumber(customer.getBranch(), walletConfig, currency.getCode()))
                .customer(customer)
                .accountType(accountType)
                .status("ACTIVE")
                .build();
        accountRepository.save(account);

        kycDto.setResponseCode(ResponseCode.SUCCESSFUL);
        kycDto.setResponseDescription(ResponseDescription.SUCCESSFUL);
        kycDto.getStructureData().put(ACCOUNT, account);
        return kycDto;
    }

    private KycDto disableAccount(KycDto kycDto) {
        Account account = accountRepository.findById(kycDto.getAccountId())
                .orElseThrow(() -> new TransactionException(ACCOUNT_NOT_FOUND, kycDto));
        account.setStatus(DISABLED);
        accountRepository.save(account);
        kycDto.setResponseCode(ResponseCode.SUCCESSFUL);
        kycDto.setResponseDescription(ResponseDescription.SUCCESSFUL);
        kycDto.getStructureData().put(ACCOUNT, account);
        return kycDto;
    }

    private KycDto attachCardToAccount(KycDto kycDto) {
        Account account = accountRepository.findById(kycDto.getAccountId())
                .orElseThrow(() -> new TransactionException(ACCOUNT_NOT_FOUND, kycDto));
        Card card = cardRepository.findById(kycDto.getCardId())
                .orElseThrow(() -> new TransactionException(CARD_NOT_FOUND, kycDto));
        if (card.getAccount() != null) {
            throw new TransactionException("Card already linked to  another account", kycDto);
        }
        card.setAccount(account);
        cardRepository.save(card);
        kycDto.setResponseCode(ResponseCode.SUCCESSFUL);
        kycDto.setResponseDescription(ResponseDescription.SUCCESSFUL);
        return kycDto;
    }

    private KycDto detachCardFromAccount(KycDto kycDto) {
        Card card = cardRepository.findById(kycDto.getCardId())
                .orElseThrow(() -> new TransactionException(CARD_NOT_FOUND, kycDto));
        if (card.getAccount() == null) {
            throw new TransactionException("Card is not linked to any account", kycDto);
        }
        card.setAccount(null);
        cardRepository.save(card);
        kycDto.setResponseCode(ResponseCode.SUCCESSFUL);
        kycDto.setResponseDescription(ResponseDescription.SUCCESSFUL);
        return kycDto;
    }

    private KycDto disableCard(KycDto kycDto) {
        Card card = cardRepository.findById(kycDto.getCardId())
                .orElseThrow(() -> new TransactionException(CARD_NOT_FOUND, kycDto));
        card.setStatus(DISABLED);
        kycDto.setResponseCode(ResponseCode.SUCCESSFUL);
        kycDto.setResponseDescription(ResponseDescription.SUCCESSFUL);
        return kycDto;
    }

    @Transactional
    public synchronized String generateAccountNumber(Branch branch, WalletConfig walletConfig, String currencyCode) {
        long count = Long.parseLong(walletConfig.getAccountNumberCount());
        String accountNumber = branch.getCode().concat(walletConfig.getAccountNumberCount()).concat(currencyCode);
        walletConfig.setAccountNumberCount(String.valueOf(++count));
        walletConfigRepository.save(walletConfig);
        return accountNumber;
    }

    @Override
    public KycDto processRequest(KycDto kycDto) {
        return switch (kycDto.getTransactionType()) {
            case TranType.CUSTOMER_ENROLMENT -> createNewCustomer(kycDto);
            case TranType.CARD_LINKING -> attachCardToAccount(kycDto);
            case TranType.ACCOUNT_DISABLEMENT -> disableAccount(kycDto);
            case TranType.CARD_DISABLEMENT -> disableCard(kycDto);
            case TranType.CUSTOMER_DISABLEMENT -> disableCustomer(kycDto);
            case TranType.ACCOUNT_CREATION -> createNewAccount(kycDto);
            case TranType.CARD_DELINKING -> detachCardFromAccount(kycDto);
            default -> throw new TransactionException("Transaction type not found", kycDto);
        };
    }
}
