package com.easypay.bankingservice.application.port.out;

import com.easypay.bankingservice.adapter.out.persistence.RegisteredBankAccountJpaEntity;
import com.easypay.bankingservice.domain.RegisteredBankAccount;

public interface RegisterBankAccountPort {
    RegisteredBankAccountJpaEntity createRegisteredBankAccount(
            RegisteredBankAccount.MembershipId membershipId,
            RegisteredBankAccount.BankName bankName,
            RegisteredBankAccount.BankAccountNumber bankAccountNumber,
            RegisteredBankAccount.LinkedStatusIsValid linkedStatusIsValid,
            RegisteredBankAccount.AggregateIdentifier aggregateIdentifier
    );

}
