package com.banking.ewallet.service.iface;


import com.banking.core.dto.transaction.WalletTransactionDto;

public interface WalletService {
    WalletTransactionDto processTellerRequest(WalletTransactionDto request);
    WalletTransactionDto processCustomerRequest(WalletTransactionDto request);
}
