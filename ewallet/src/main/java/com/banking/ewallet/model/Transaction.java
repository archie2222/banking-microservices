//package com.banking.ewallet.model;
//
//import com.banking.core.dto.transaction.WalletAccountDto;
//import com.banking.core.dto.transaction.WalletCardDto;
//import com.banking.ewallet.util.MapToJsonDataAttributeConverter;
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import org.hibernate.annotations.GenericGenerator;
//
//import java.math.BigDecimal;
//import java.util.LinkedHashMap;
//import java.util.Map;
//
//@AllArgsConstructor
//@NoArgsConstructor
//@Getter
//@Setter
//@Entity
//public class Transaction {
//    @Id
//    @GeneratedValue(
//            generator = "UUID"
//    )
//    @GenericGenerator(
//            name = "UUID",
//            strategy = "org.hibernate.id.UUIDGenerator"
//    )
//    protected String id;
//    private String acquirer;
//    private String issuer;
//    private BigDecimal amount;
//    private Card walletCardDto;
//    private String sourceChannel;
//    private Account sourceAccount;
//    private String transactionReference;
//    private String currencyCode;
//    private Account destinationAccount;
//    private String destinationBIN;
//    private String destinationMsisdn;
//    private String descriptiveTransactionType;
//    private String msisdn;
//    private String narration;
//    private String beneficiary;
//    private String beneficiaryService;
//    private String reference;
//    private String responseCode;
//    private String responseDescription;
//    private String transactionType;
//    private String propagatedResponseCode;
//    private String propagatedResponseDescription;
//    @Column(
//            length = 255
//    )
//    @Convert(
//            converter = MapToJsonDataAttributeConverter.class
//    )
//    private Map<String, Object> structureData = new LinkedHashMap();
//}
