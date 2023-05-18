package com.banking.core.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class Configs {
    @Bean
    public WebClient createWebClient(){
        return WebClient.builder().defaultHeader("Content-Type", new String[]{"application/json"}).build();
    }
}
