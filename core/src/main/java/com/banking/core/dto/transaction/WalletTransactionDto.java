package com.banking.core.dto.transaction;

import lombok.*;

import java.math.BigDecimal;
import java.util.Map;
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class WalletTransactionDto {
        private String acquirer;
        private String issuer;
        private BigDecimal amount;
        private WalletCardDto walletCardDto;
        private String sourceChannel;
        private WalletAccountDto sourceAccount;
        private String transactionReference;
        private String currencyCode;
        private WalletAccountDto destinationAccount;
        private String destinationBIN;
        private String destinationMsisdn;
        private String descriptiveTransactionType;
        private String msisdn;
        private String narration;
        private String beneficiary;
        private String beneficiaryService;
        private String reference;
        private String responseCode;
        private String responseDescription;
        private String transactionType;
        private String propagatedResponseCode;
        private String propagatedResponseDescription;
        private Map<String, Object> structureData;

}
