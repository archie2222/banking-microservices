package com.banking.ewallet.service.impl;

import com.banking.core.dto.api.ResponseCode;
import com.banking.core.dto.api.ResponseDescription;
import com.banking.core.dto.kyc.KycDto;
import com.banking.core.dto.transaction.DescriptiveType;
import com.banking.core.exception.TransactionException;
import com.banking.ewallet.model.*;
import com.banking.ewallet.repository.*;
import com.banking.ewallet.service.iface.AdministrativeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.banking.core.util.Util.mapToString;


@Service
@Slf4j
@RequiredArgsConstructor
public class AdministrativeServiceImpl implements AdministrativeService {
    private final AccountTypeRepository accountTypeRepository;
    private final CustomerTypeRepository customerTypeRepository;
    private final BranchRepository branchRepository;
    private final CurrencyRepository currencyRepository;
    private final ChargeRepository chargeRepository;
    @Override
    public KycDto processRequest(KycDto request) {
        return switch (request.getDescriptiveTransactionType()) {
            case DescriptiveType.CUSTOMER_TYPE_CREATION -> createCustomerType(request);
            case DescriptiveType.ACCOUNT_TYPE_CREATION -> createAccountType(request);
            case DescriptiveType.CURRENCY_CREATION -> createCurrency(request);
            case DescriptiveType.BRANCH_CREATION -> createBranch(request);
            default -> throw new TransactionException("Transaction type not found", request);
        };

    }

    private KycDto createBranch(KycDto dto) {
        Branch branch = Branch
                .builder()
                .code(mapToString(dto.getStructureData(),"BRANCH_CODE"))
                .name(mapToString(dto.getStructureData(),"BRANCH_NAME"))
                .build();
        this.branchRepository.save(branch);
        dto.setResponseCode(ResponseCode.SUCCESSFUL);
        dto.setResponseDescription(ResponseDescription.SUCCESSFUL);
        return dto;
    }

    private KycDto createCurrency(KycDto dto) {
        Currency currency = Currency
                .builder()
                .code(mapToString(dto.getStructureData(),"CURRENCY_CODE"))
                .name(mapToString(dto.getStructureData(),"CURRENCY_NAME"))
                .description(mapToString(dto.getStructureData(),"CURRENCY_DESCRIPTION"))
                .build();
        this.currencyRepository.save(currency);
        dto.setResponseCode(ResponseCode.SUCCESSFUL);
        dto.setResponseDescription(ResponseDescription.SUCCESSFUL);
        return dto;
    }

    private KycDto createAccountType(KycDto dto) {
        Charge charge = chargeRepository.findById(dto.getChargeId()).orElseThrow(() -> new TransactionException("Charge not found", dto));
        AccountType accountType =AccountType
                .builder()
                .charge(charge)
                .name(mapToString(dto.getStructureData(),"ACCOUNT_TYPE_NAME"))
                .currency(mapToString(dto.getStructureData(),"CURRENCY"))
                .build();
        this.accountTypeRepository.save(accountType);
        dto.setResponseCode(ResponseCode.SUCCESSFUL);
        dto.setResponseDescription(ResponseDescription.SUCCESSFUL);
        return dto;
    }

    private KycDto createCustomerType(KycDto dto) {
        CustomerType customerType = CustomerType
                .builder()
                .name(mapToString(dto.getStructureData(),"CUSTOMER_TYPE_NAME"))
                .build();
        this.customerTypeRepository.save(customerType);
        dto.setResponseCode(ResponseCode.SUCCESSFUL);
        dto.setResponseDescription(ResponseDescription.SUCCESSFUL);
        return dto;
    }
}
