package com.easypay.membershipservice.adapter.in.web;


import com.easypay.common.WebAdapter;
import com.easypay.membershipservice.application.port.in.AuthMembershipUseCase;
import com.easypay.membershipservice.application.port.in.LoginMembershipCommand;
import com.easypay.membershipservice.application.port.in.RefreshTokenCommand;
import com.easypay.membershipservice.application.port.in.ValidateTokenCommand;
import com.easypay.membershipservice.domain.JwtToken;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@WebAdapter
@RestController
@RequiredArgsConstructor
public class AuthMembershipController {
    private final AuthMembershipUseCase authMembershipUseCase;
    @PostMapping(path = "/membership/login")
    JwtToken loginMembership(@RequestBody LoginMembershipRequest request) {
        LoginMembershipCommand command = LoginMembershipCommand.builder()
                .membershipId(request.getMembershipId())
                .build();

        return authMembershipUseCase.loginMembership(command);
    }

    @PostMapping(path = "/membership/refresh-token")
    JwtToken refreshToken(@RequestBody RefreshTokenRequest request) {
        RefreshTokenCommand command = RefreshTokenCommand.builder()
                .refreshToken(request.getRefreshToken())
                .build();

        return authMembershipUseCase.refreshJwtTokenByRefreshToken(command);
    }

    @PostMapping(path = "/membership/token-validate")
    boolean validateToken(@RequestBody ValidateTokenRequest request) {
        ValidateTokenCommand command = ValidateTokenCommand.builder()
                .jwtToken(request.getJwtToken())
                .build();

        return authMembershipUseCase.validateJwtToken(command);
    }
}