package com.easypay.membershipservice.application.port.in;
import com.easypay.common.SelfValidating;
import jakarta.validation.constraints.AssertTrue;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Builder
@Getter
@EqualsAndHashCode(callSuper = false)
public class RegisterMembershipCommand extends SelfValidating<RegisterMembershipCommand> {

    @NotNull
    private final String name;
    @NotNull
    private final String email;
    @NotNull
    private final String address;
    @AssertTrue
    private final boolean isValid;
    private final boolean isCorp;

    public RegisterMembershipCommand(String name, String email, String address, boolean isValid, boolean isCorp) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.isValid = isValid;
        this.isCorp = isCorp;
        this.validateSelf();
    }
}
