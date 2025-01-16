package com.easypay.membershipservice.adapter.in.web;

import com.easypay.membershipservice.application.port.in.RegisterMembershipCommand;
import com.easypay.membershipservice.application.port.in.RegisterMembershipUseCase;
import com.easypay.membershipservice.domain.Membership;
import common.WebAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequiredArgsConstructor
public class RegisterMembershipController {
    private final RegisterMembershipUseCase registerMembershipUseCase;

    @PostMapping(path ="/membership/register")
    Membership registerMembership(@RequestBody RegisterMembershipRequest request) {
        // request ~~

        // request -> command


        // Usecase ~~(request x, command)

        RegisterMembershipCommand command = RegisterMembershipCommand.builder()
                .name(request.getName())
                .address(request.getAddress())
                .email(request.getEmail())
                .isValid(true)
                .isCorp(request.isCorp()).build();

        return registerMembershipUseCase.registerMembership(command);


    }

}
