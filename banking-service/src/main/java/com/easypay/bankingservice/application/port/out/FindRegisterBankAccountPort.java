package com.easypay.bankingservice.application.port.out;

import com.easypay.bankingservice.adapter.out.persistence.RegisteredBankAccountJpaEntity;
import com.easypay.bankingservice.domain.RegisteredBankAccount;

public interface FindRegisterBankAccountPort {
    RegisteredBankAccountJpaEntity findRegisteredBankAccount(
            RegisteredBankAccount.MembershipId membershipId
    );

}
