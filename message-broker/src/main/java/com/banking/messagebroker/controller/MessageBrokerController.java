package com.banking.messagebroker.controller;

import com.banking.core.dto.transaction.WalletTransactionDto;
import com.banking.messagebroker.config.KafKaProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/messages")
public class MessageBrokerController {
    private final KafKaProducerService producerService;
    @PostMapping()
    public void sendMessageToKafkaTopic(@RequestBody WalletTransactionDto dto) {
        this.producerService.sendMessage(dto);
    }
}
