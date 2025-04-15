package com.easypay.paymentservice.application.port.out;

public interface GetRegisteredBankAccountPort {
    RegisteredBankAccountAggregateIdentifier getRegisteredBankAccount(String membershipId);
}