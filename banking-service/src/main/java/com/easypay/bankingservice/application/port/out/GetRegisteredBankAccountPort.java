package com.easypay.bankingservice.application.port.out;


import com.easypay.bankingservice.adapter.out.persistence.RegisteredBankAccountJpaEntity;
import com.easypay.bankingservice.application.port.in.GetRegisteredBankAccountCommand;

public interface GetRegisteredBankAccountPort {
    RegisteredBankAccountJpaEntity getRegisteredBankAccount(GetRegisteredBankAccountCommand command);
}