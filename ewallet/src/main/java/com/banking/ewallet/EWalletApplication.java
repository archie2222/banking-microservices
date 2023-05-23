package com.banking.ewallet;

import com.banking.ewallet.security.JwtAuthConverterProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;


@SpringBootApplication(scanBasePackages = {"com.banking.core"})
@EnableConfigurationProperties(JwtAuthConverterProperties.class)
public class EWalletApplication {

    public static void main(String[] args) {
        SpringApplication.run(EWalletApplication.class, args);
    }

}
