package com.banking.notification.service;

import com.banking.core.dto.kyc.KycDto;
import com.banking.core.dto.transaction.WalletTransactionDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafKaConsumerService {
    @KafkaListener(topics = "transactionJsonTopic",
            groupId = "txn-banking")
    public void consume(KycDto dto)
    {
        log.info(String.format("Listener Received: -> %s", dto));
    }
}
