package com.banking.ewallet.service.iface;


import com.banking.core.dto.transaction.WalletTransactionDto;

public interface StatementEnquiryService {
    WalletTransactionDto processBalanceEnquiry(WalletTransactionDto request);

}
