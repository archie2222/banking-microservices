package com.banking.core.dto.transaction;

import lombok.Data;
@Data
public class TranType {
    public static final String ENQUIRY = "ENQUIRY";
    public static final String PAYMENT = "PAYMENT";
    public static final String TRANSFER = "TRANSFER";
    public static final String CASH_DEPOSIT = "CASH_DEPOSIT";
    public static final String CASH_WITHDRAWAL = "CASH_WITHDRAWAL";
}
