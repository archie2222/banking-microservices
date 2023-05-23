package com.banking.core.dto.transaction;

import lombok.Data;
@Data
public class TranType {
    public static final String ENQUIRY = "ENQUIRY";
    public static final String PAYMENT = "PAYMENT";
    public static final String TRANSFER = "TRANSFER";
    public static final String CASH_DEPOSIT = "CASH_DEPOSIT";
    public static final String CASH_WITHDRAWAL = "CASH_WITHDRAWAL";
    public static final String CUSTOMER_ENROLMENT = "CUSTOMER_ENROLLMENT";
    public static final String CUSTOMER_DISABLEMENT = "CUSTOMER_DISABLEMENT";
    public static final String ACCOUNT_CREATION = "ACCOUNT_CREATION";
    public static final String ACCOUNT_DISABLEMENT = "ACCOUNT_DISABLEMENT";
    public static final String CARD_LINKING = "CARD_LINKING";
    public static final String CARD_DELINKING = "CARD_DELINKING";
    public static final String CARD_DISABLEMENT = "CARD_DISABLEMENT";
}
