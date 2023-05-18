package com.banking.core.exception;

import com.banking.core.dto.api.ResponseCode;
import com.banking.core.dto.transaction.WalletTransactionDto;

public class TransactionException extends RuntimeException{
    public TransactionException(String message, WalletTransactionDto transactionDto) {
        transactionDto.setResponseCode(ResponseCode.FAILED);
        transactionDto.setResponseDescription(message);
    }
}
