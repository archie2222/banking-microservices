package com.banking.core.dto.transaction;

import lombok.*;



@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class WalletAccountDto {
    private     String              currency;
    private     String              type;
}
