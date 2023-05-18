package com.banking.core.dto.transaction;

import lombok.*;

import java.time.LocalDate;
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class WalletCardDto {
    private String    pan;
    private LocalDate expiry;
    private String    pin;

}
