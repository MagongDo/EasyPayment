package com.easypay.bankingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication

public class BankingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankingServiceApplication.class, args);
    }

}
