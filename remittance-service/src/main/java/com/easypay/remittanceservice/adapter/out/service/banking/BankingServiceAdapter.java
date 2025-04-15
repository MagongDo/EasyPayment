package com.easypay.remittanceservice.adapter.out.service.banking;


import com.easypay.common.CommonHttpClient;
import com.easypay.common.ExternalSystemAdapter;
import com.easypay.remittanceservice.application.port.out.banking.BankingInfo;
import com.easypay.remittanceservice.application.port.out.banking.BankingPort;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

@ExternalSystemAdapter
@RequiredArgsConstructor
public class BankingServiceAdapter implements BankingPort {

    private final CommonHttpClient bankingServiceHttpClient;

    @Value("${service.banking.url}")
    private String bankingServiceEndpoint;


    @Override
    public BankingInfo getMembershipBankingInfo(String bankName, String bankAccountNumber) {

        return null;
    }

    @Override
    public boolean requestFirmbanking(String bankName, String bankAccountNumber, int amount) {
        return false;
    }
}