package com.banking.ewallet.service.impl;

import com.banking.core.dto.transaction.WalletTransactionDto;
import com.banking.ewallet.repository.CustomerRepository;
import com.banking.ewallet.service.iface.EnquiryService;
import com.banking.ewallet.service.iface.WalletService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public record EnquiryServiceImpl(CustomerRepository customerRepository) implements EnquiryService {


    @Override
    public WalletTransactionDto customerEnquiryByAccount(WalletTransactionDto request) {
        return null;
    }

    @Override
    public WalletTransactionDto customerEnquiryByCustomerId(WalletTransactionDto request) {
        return null;
    }
}
