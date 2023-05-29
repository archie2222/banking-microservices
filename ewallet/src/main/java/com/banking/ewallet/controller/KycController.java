package com.banking.ewallet.controller;

import com.banking.core.dto.kyc.KycDto;
import com.banking.ewallet.service.iface.KycService;
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
@RequestMapping("/api/v1/kyc")
@RequiredArgsConstructor
public class KycController {
    private final KycService kycService;
    @PostMapping()
    @PreAuthorize("hasAuthority('teller')")
    public ResponseEntity<KycDto> processCustomerRequest(@RequestBody KycDto request) {
        return ResponseEntity.ok(kycService.processRequest(request));
    }
}
