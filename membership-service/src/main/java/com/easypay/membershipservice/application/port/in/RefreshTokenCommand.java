package com.easypay.membershipservice.application.port.in;

import com.easypay.common.SelfValidating;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode(callSuper = false)
public
class RefreshTokenCommand extends SelfValidating<RefreshTokenCommand> {
    private final String refreshToken;

}