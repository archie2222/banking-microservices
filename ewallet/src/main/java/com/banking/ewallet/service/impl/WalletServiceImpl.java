package com.banking.ewallet.service.impl;


import com.banking.core.dto.transaction.TranType;
import com.banking.core.dto.transaction.WalletTransactionDto;
import com.banking.core.exception.TransactionException;
import com.banking.ewallet.service.iface.WalletService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class WalletServiceImpl implements WalletService {
    @Override
    public WalletTransactionDto processCustomerRequest(WalletTransactionDto request) {
        return switch (request.getTransactionType()) {
            case TranType.ENQUIRY -> processEnquiry(request);
            case TranType.TRANSFER -> processTransfer(request);
            case TranType.PAYMENT -> processPayment(request);
            default -> throw new TransactionException("Transaction type not found", request);
        };
    }

    @Override
    public WalletTransactionDto processTellerRequest(WalletTransactionDto request) {
        return switch (request.getTransactionType()) {
            case TranType.ENQUIRY -> processEnquiry(request);
            case TranType.PAYMENT -> processPayment(request);
            case TranType.CASH_WITHDRAWAL -> processCashWithdrawal(request);
            case TranType.CASH_DEPOSIT -> processCashDeposit(request);
            default -> throw new TransactionException("Transaction type not found", request);
        };
    }


    private WalletTransactionDto processCashDeposit(WalletTransactionDto request) {
        return null;
    }

    private WalletTransactionDto processCashWithdrawal(WalletTransactionDto request) {
        return null;
    }

    private WalletTransactionDto processPayment(WalletTransactionDto request) {
        return null;
    }

    private WalletTransactionDto processTransfer(WalletTransactionDto request) {
        return null;
    }

    private WalletTransactionDto processEnquiry(WalletTransactionDto request) {
        return null;
    }


}
