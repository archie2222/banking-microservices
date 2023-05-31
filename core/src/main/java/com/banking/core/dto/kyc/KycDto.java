package com.banking.core.dto.kyc;

import com.banking.core.dto.transaction.WalletAccountDto;
import lombok.*;

import java.time.LocalDate;
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
    private String customerTypeId;
    private String customerId;
    private String chargeId;
    private String cardId;
    private String accountId;
    private String branchId;
    private String accountTypeId;
    private String currencyId;
    private String address;
    private String msisdn;
    private String email;
    private LocalDate dob;
    private String narration;
    private String reference;
    private String responseCode;
    private String responseDescription;
    private String transactionType;
    private String descriptiveTransactionType;
    private String propagatedResponseCode;
    private String propagatedResponseDescription;
    private Map<String, Object> structureData;
    private Set<WalletAccountDto> accountDto;
}
