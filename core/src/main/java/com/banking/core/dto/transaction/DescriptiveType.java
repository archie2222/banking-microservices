package com.banking.core.dto.transaction;

import lombok.Data;

@Data
public class DescriptiveType {

    public static final String CUSTOMER_ENROLMENT = "CUSTOMER_ENROLLMENT";
    public static final String CUSTOMER_DISABLEMENT = "CUSTOMER_DISABLEMENT";
    public static final String ACCOUNT_CREATION = "ACCOUNT_CREATION";
    public static final String ACCOUNT_DISABLEMENT = "ACCOUNT_DISABLEMENT";
    public static final String CARD_LINKING = "CARD_LINKING";
    public static final String CARD_DELINKING = "CARD_DELINKING";
    public static final String CARD_DISABLEMENT = "CARD_DISABLEMENT";
    public static final String CUSTOMER_TYPE_CREATION = "CUSTOMER_TYPE_CREATION";
    public static final String ACCOUNT_TYPE_CREATION = "ACCOUNT_TYPE_CREATION";
    public static final String CURRENCY_CREATION = "CURRENCY_CREATION";
    public static final String BRANCH_CREATION = "BRANCH_CREATION";

}
