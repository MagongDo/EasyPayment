package com.easypay.bankingservice.application.service;


import com.easypay.bankingservice.adapter.axon.command.CreateRegisteredBankAccountCommand;
import com.easypay.bankingservice.adapter.out.external.bank.BankAccount;
import com.easypay.bankingservice.adapter.out.external.bank.GetBankAccountRequest;
import com.easypay.bankingservice.adapter.out.persistence.RegisteredBankAccountJpaEntity;
import com.easypay.bankingservice.adapter.out.persistence.RegisteredBankAccountMapper;
import com.easypay.bankingservice.application.port.in.GetRegisteredBankAccountCommand;
import com.easypay.bankingservice.application.port.in.GetRegisteredBankAccountUseCase;
import com.easypay.bankingservice.application.port.in.RegisterBankAccountCommand;
import com.easypay.bankingservice.application.port.in.RegisterBankAccountUseCase;
import com.easypay.bankingservice.application.port.out.*;
import com.easypay.bankingservice.domain.RegisteredBankAccount;
import com.easypay.common.UseCase;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.transaction.annotation.Transactional;


@UseCase
@RequiredArgsConstructor
@Transactional
public class RegisterBankAccountService implements RegisterBankAccountUseCase, GetRegisteredBankAccountUseCase {

    private final GetMembershipPort getMembershipPort;
    private final RegisterBankAccountPort registerBankAccountPort;
    private final RegisteredBankAccountMapper mapper;
    private final RequestBankAccountInfoPort requestBankAccountInfoPort;
    private final GetRegisteredBankAccountPort getRegisteredBankAccountPort;;
    private final CommandGateway commandGateway;
    @Override
    public RegisteredBankAccount registerBankAccount(RegisterBankAccountCommand command) {

        // 은행 계좌를 등록해야하는 서비스 (비즈니스 로직)
        // command.getMembershipId()

        // call membership svc, 정상인지 확인
        // call external bank svc, 정상인지 확인
        MembershipStatus membershipStatus = getMembershipPort.getMembership(command.getMembershipId());
        if(!membershipStatus.isValid()) {
            return null;
        }

        // 1. 외부 실제 은행에 등록이 가능한 계좌인지(정상인지) 확인한다.
        // 외부의 은행에 이 계좌 정상인지? 확인을 해야해요.
        // Biz Logic -> External System
        // Port -> Adapter -> External System
        // Port
        // 실제 외부의 은행계좌 정보를 Get
        BankAccount accountInfo = requestBankAccountInfoPort.getBankAccountInfo(new GetBankAccountRequest(command.getBankName(), command.getBankAccountNumber()));
        boolean accountIsValid =  accountInfo.isValid();

        // 2. 등록가능한 계좌라면, 등록한다. 성공하면, 등록에 성공한 등록 정보를 리턴
        // 2-1. 등록가능하지 않은 계좌라면. 에러를 리턴
        if(accountIsValid) {
            // 등록 정보 저장
            RegisteredBankAccountJpaEntity savedAccountInfo = registerBankAccountPort.createRegisteredBankAccount(
                    new RegisteredBankAccount.MembershipId(command.getMembershipId()+""),
                    new RegisteredBankAccount.BankName(command.getBankName()),
                    new RegisteredBankAccount.BankAccountNumber(command.getBankAccountNumber()),
                    new RegisteredBankAccount.LinkedStatusIsValid(command.isValid()),
                    new RegisteredBankAccount.AggregateIdentifier("")
            );
            return mapper.mapToDomainEntity(savedAccountInfo);
        } else {
            return null;
        }
    }

    @Override
    public void registerBankAccountByEvent(RegisterBankAccountCommand command) {
        commandGateway.send(new CreateRegisteredBankAccountCommand(command.getMembershipId(), command.getBankName(), command.getBankAccountNumber())).whenComplete(
                (result, throwable) -> {
                    if(throwable != null) {
                        System.out.println("throwable = " + throwable);
                    }
                    registerBankAccountPort.createRegisteredBankAccount(
                            new RegisteredBankAccount.MembershipId(command.getMembershipId()+""),
                            new RegisteredBankAccount.BankName(command.getBankName()),
                            new RegisteredBankAccount.BankAccountNumber(command.getBankAccountNumber()),
                            new RegisteredBankAccount.LinkedStatusIsValid(command.isValid()),
                            new RegisteredBankAccount.AggregateIdentifier(result.toString())
                    );
                }
        );
    }

    @Override
    public RegisteredBankAccount getRegisteredBankAccount(GetRegisteredBankAccountCommand command) {
        return mapper.mapToDomainEntity(getRegisteredBankAccountPort.getRegisteredBankAccount(command));
    }
}