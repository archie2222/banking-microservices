package com.banking.messagebroker.config;

import com.banking.core.dto.transaction.WalletTransactionDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafKaProducerService {
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void sendMessage(WalletTransactionDto dto)
    {
        log.info(String.format("Request: -> %s", dto));
        this.kafkaTemplate.send("transactionJsonTopic", dto);
    }
}
