package com.banking.ewallet.service.iface;

import com.banking.core.dto.transaction.WalletTransactionDto;

public interface EnquiryService {
    WalletTransactionDto customerEnquiryByAccount(WalletTransactionDto request);
    WalletTransactionDto customerEnquiryByCustomerId(WalletTransactionDto request);
}
