package com.banking.core.dto.transaction;

import lombok.Data;

@Data
public class DescriptiveType {

    public static final String ACCOUNT = "ACCOUNT";
    public static final String CARD = "CARD";
    public static final String AIRTIME = "AIRTIME";
    public static final String BALANCE = "BALANCE";
    public static final String BILL = "BILL";
    public static final String USER_ENROLLMENT = "USER_ENROLLMENT";
    public static final String CREDIT = "CREDIT";
    public static final String DEBIT = "DEBIT";
    public static final String FULL_STATEMENT = "FULL_STATEMENT";
    public static final String INTERNAL = "INTERNAL";
    public static final String BANK_TO_BANK = "BANK_TO_BANK";
    public static final String POSTPAID = "POSTPAID";
    public static final String PREPAID = "PREPAID";

}
