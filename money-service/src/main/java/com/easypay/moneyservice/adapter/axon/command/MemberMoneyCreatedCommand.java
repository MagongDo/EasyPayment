package com.easypay.moneyservice.adapter.axon.command;


import com.easypay.common.SelfValidating;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;



@Builder
@Data
@EqualsAndHashCode(callSuper = false)
public class MemberMoneyCreatedCommand extends SelfValidating<MemberMoneyCreatedCommand> {

    @NotNull
    private String membershipId;

    public MemberMoneyCreatedCommand(@NotNull String targetMembershipId) {
        this.membershipId = targetMembershipId;
        this.validateSelf();
    }

    public MemberMoneyCreatedCommand() {
    }
}