package com.easypay.moneyservice.adapter.axon.aggregate;


import com.easypay.moneyservice.adapter.axon.command.IncreaseMemberMoneyCommand;
import com.easypay.moneyservice.adapter.axon.command.MemberMoneyCreatedCommand;
import com.easypay.moneyservice.adapter.axon.command.RechargingMoneyRequestCreateCommand;
import com.easypay.moneyservice.adapter.axon.event.IncreaseMemberMoneyEvent;
import com.easypay.moneyservice.adapter.axon.event.MemberMoneyCreatedEvent;
import com.easypay.moneyservice.adapter.axon.event.RechargingRequestCreatedEvent;
import com.easypay.moneyservice.application.port.out.GetRegisteredBankAccountPort;
import com.easypay.moneyservice.application.port.out.RegisteredBankAccountAggregateIdentifier;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.UUID;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Aggregate()
@Data
public class MemberMoneyAggregate {
    @AggregateIdentifier
    private String id;

    private Long membershipId;

    private int balance;

    @CommandHandler
    public MemberMoneyAggregate(MemberMoneyCreatedCommand command) {
        System.out.println("MemberMoneyCreatedCommand Handler");

        apply(new MemberMoneyCreatedEvent(command.getMembershipId()));
    }

    @CommandHandler
    public String handle(@NotNull IncreaseMemberMoneyCommand command){
        System.out.println("IncreaseMemberMoneyCommand Handler");
        id = command.getAggregateIdentifier();

        // store event
        apply(new IncreaseMemberMoneyEvent(id, command.getMembershipId(), command.getAmount()));
        return id;
    }

    @CommandHandler
    public void handler(RechargingMoneyRequestCreateCommand command, GetRegisteredBankAccountPort getRegisteredBankAccountPort){
        System.out.println("RechargingMoneyRequestCreateCommand Handler");
        id = command.getAggregateIdentifier();


        // new RechargingRequestCreatedEvent
        // banking 정보가 필요해요. -> bank svc (get RegisteredBankAccount) 를 위한. Port.
        RegisteredBankAccountAggregateIdentifier registeredBankAccountAggregateIdentifier
                = getRegisteredBankAccountPort.getRegisteredBankAccount(command.getMembershipId());

        // Saga Start
        apply(new RechargingRequestCreatedEvent(
                command.getRechargingRequestId(),
                command.getMembershipId(),
                command.getAmount(),
                registeredBankAccountAggregateIdentifier.getAggregateIdentifier(),
                registeredBankAccountAggregateIdentifier.getBankName(),
                registeredBankAccountAggregateIdentifier.getBankAccountNumber()
        ));
    }

    @EventSourcingHandler
    public void on(MemberMoneyCreatedEvent event) {
        System.out.println("MemberMoneyCreatedEvent Sourcing Handler");
        id = UUID.randomUUID().toString();
        membershipId = Long.parseLong(event.getMembershipId());
        balance = 0;
    }

    @EventSourcingHandler
    public void on(IncreaseMemberMoneyEvent event) {
        System.out.println("IncreaseMemberMoneyEvent Sourcing Handler");
        id = event.getAggregateIdentifier();
        membershipId = Long.parseLong(event.getTargetMembershipId());
        balance = event.getAmount();
    }

    public MemberMoneyAggregate() {
    }
}