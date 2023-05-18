package com.banking.ewallet.service.iface;

import com.banking.core.dto.transaction.WalletTransactionDto;

public interface InternalTransferService {
    WalletTransactionDto processInternalTransfer(WalletTransactionDto request);

}
