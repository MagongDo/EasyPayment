package com.easypay.bankingservice.application.port.in;

import com.easypay.bankingservice.domain.RegisteredBankAccount;

public interface RegisterBankAccountUseCase {
    RegisteredBankAccount registerBankAccount(RegisterBankAccountCommand command);
    void registerBankAccountByEvent(RegisterBankAccountCommand command);
}
