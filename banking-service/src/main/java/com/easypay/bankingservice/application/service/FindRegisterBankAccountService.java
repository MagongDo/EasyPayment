package com.easypay.bankingservice.application.service;

import com.easypay.bankingservice.adapter.out.persistence.RegisteredBankAccountJpaEntity;
import com.easypay.bankingservice.adapter.out.persistence.RegisteredBankAccountMapper;
import com.easypay.bankingservice.application.port.in.FindRegisterBankAccountCommand;
import com.easypay.bankingservice.application.port.in.FindRegisterBankAccountUseCase;
import com.easypay.bankingservice.application.port.out.FindRegisterBankAccountPort;
import com.easypay.bankingservice.domain.RegisteredBankAccount;
import com.easypay.common.UseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@RequiredArgsConstructor
@Transactional

public class FindRegisterBankAccountService implements FindRegisterBankAccountUseCase {
    FindRegisterBankAccountPort port;
    RegisteredBankAccountMapper mapper;

    @Override
    public RegisteredBankAccount findRegisteredBankAccount(FindRegisterBankAccountCommand command) {
        RegisteredBankAccountJpaEntity entity = port.findRegisteredBankAccount(new RegisteredBankAccount.MembershipId(command.getMembershipId()));
        return mapper.mapToDomainEntity(entity);
    }
}

