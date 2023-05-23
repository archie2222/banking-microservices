package com.banking.ewallet.service.iface;

import com.banking.core.dto.kyc.KycDto;

public interface KycService {
    KycDto processRequest(KycDto kycDto);

}
