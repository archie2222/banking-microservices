package com.banking.core.dto.kyc;

import com.banking.core.dto.transaction.WalletAccountDto;
import com.banking.core.dto.transaction.WalletCardDto;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class KycDto {
    private String sourceChannel;
    private String firstName;
    private String lastName;
    private String title;
    private String nationalId;
    private String address;
    private String msisdn;
    private String narration;
    private String reference;
    private String responseCode;
    private String responseDescription;
    private String transactionType;
    private String propagatedResponseCode;
    private String propagatedResponseDescription;
    private Map<String, Object> structureData;
    private Set<WalletAccountDto> accountDto;
}
