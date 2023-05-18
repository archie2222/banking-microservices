package com.banking.core.dto.api;

import lombok.Data;

@Data
public class ResponseDescription {
    public static final String SUCCESSFUL = "Transaction processed successfully";
    public static final String FAILED = "Transaction failed";
}
