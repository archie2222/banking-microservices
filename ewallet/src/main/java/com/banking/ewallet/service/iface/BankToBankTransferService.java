package com.banking.ewallet.service.iface;

import com.banking.core.dto.transaction.WalletTransactionDto;

public interface BankToBankTransferService {
    WalletTransactionDto processInternalTransfer(WalletTransactionDto request);

}
