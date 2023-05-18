package com.banking.ewallet.controller;

import com.banking.core.dto.transaction.WalletTransactionDto;
import com.banking.ewallet.service.iface.WalletService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/api/v1/")
@RequiredArgsConstructor
public class WalletTransactionController {
    private final WalletService walletService;
    @PostMapping("customer/transaction")
    @PreAuthorize("hasAuthority('customer')")
    public ResponseEntity<WalletTransactionDto> processCustomerRequest(@RequestBody WalletTransactionDto request) {
        return ResponseEntity.ok(walletService.processCustomerRequest(request));
    }

    @PostMapping("teller/transaction")
    @PreAuthorize("hasAuthority('teller')")
    public ResponseEntity<WalletTransactionDto> processTellerRequest(@RequestBody WalletTransactionDto request) {
        return ResponseEntity.ok(walletService.processTellerRequest(request));
    }

}
