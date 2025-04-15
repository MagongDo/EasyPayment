package com.easypay.moneyservice.adapter.axon.event;

import com.easypay.common.SelfValidating;
import jakarta.validation.constraints.NotNull;
import lombok.*;


@Builder
@Data
@EqualsAndHashCode(callSuper = false)
public class MemberMoneyCreatedEvent extends SelfValidating<MemberMoneyCreatedEvent> {

    @NotNull
    private String membershipId;

    public MemberMoneyCreatedEvent(@NotNull String targetMembershipId) {
        this.membershipId = targetMembershipId;
        this.validateSelf();
    }

    public MemberMoneyCreatedEvent() {
    }
}