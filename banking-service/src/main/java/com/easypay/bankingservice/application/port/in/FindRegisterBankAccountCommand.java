package com.easypay.bankingservice.application.port.in;

import com.easypay.common.SelfValidating;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Builder
@Data
@EqualsAndHashCode(callSuper = false)
public class FindRegisterBankAccountCommand extends SelfValidating<FindRegisterBankAccountCommand> {
    @NotNull
    private final String membershipId;


    public FindRegisterBankAccountCommand(String membershipId) {
        this.membershipId = membershipId;
        this.validateSelf();
    }
}
