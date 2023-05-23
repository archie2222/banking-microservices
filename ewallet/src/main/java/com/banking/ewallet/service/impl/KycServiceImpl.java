package com.banking.ewallet.service.impl;

import com.banking.core.dto.kyc.KycDto;
import com.banking.core.dto.transaction.TranType;
import com.banking.core.exception.TransactionException;
import com.banking.ewallet.service.iface.KycService;
import org.springframework.stereotype.Service;

@Service
public class KycServiceImpl implements KycService {

    private KycDto createNewCustomer(KycDto kycDto) {
        return null;
    }


    private KycDto disableCustomer(KycDto kycDto) {
        return null;
    }

    private KycDto createNewAccount(KycDto kycDto) {
        return null;
    }

    private KycDto disableAccount(KycDto kycDto) {
        return null;
    }

    private KycDto attachCardToAccount(KycDto kycDto) {
        return null;
    }

    private KycDto detachCardFromAccount(KycDto kycDto) {
        return null;
    }

    private KycDto disableCard(KycDto kycDto) {
        return null;
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
