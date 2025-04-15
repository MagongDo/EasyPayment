package com.easypay.moneyservice.adapter.axon.event;


import com.easypay.common.SelfValidating;
import com.easypay.moneyservice.application.port.in.IncreaseMoneyRequestCommand;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;



@Builder
@Data
@EqualsAndHashCode(callSuper = false)
public class IncreaseMemberMoneyEvent extends SelfValidating<IncreaseMemberMoneyEvent> {
    private String aggregateIdentifier;
    private String targetMembershipId;
    private int amount;

    public IncreaseMemberMoneyEvent(String aggregateIdentifier, String targetMembershipId, int amount) {
        this.aggregateIdentifier = aggregateIdentifier;
        this.targetMembershipId = targetMembershipId;
        this.amount = amount;
    }

    public IncreaseMemberMoneyEvent() {
    }
}