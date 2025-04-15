package com.easypay.membershipservice.application.port.in;


import com.easypay.membershipservice.domain.JwtToken;
import com.easypay.membershipservice.domain.Membership;

public interface AuthMembershipUseCase {
    JwtToken loginMembership(LoginMembershipCommand command);

    JwtToken refreshJwtTokenByRefreshToken(RefreshTokenCommand command);
    boolean validateJwtToken(ValidateTokenCommand command);

    Membership getMembershipByJwtToken(ValidateTokenCommand command);
}