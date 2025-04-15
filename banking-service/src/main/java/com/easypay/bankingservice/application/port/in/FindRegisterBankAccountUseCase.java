package com.easypay.bankingservice.application.port.in;

import com.easypay.bankingservice.domain.RegisteredBankAccount;

public interface FindRegisterBankAccountUseCase {
        RegisteredBankAccount findRegisteredBankAccount(FindRegisterBankAccountCommand command);
}
