package com.easypay.membershipservice.adapter.in.web;

import com.easypay.common.WebAdapter;
import com.easypay.membershipservice.application.port.in.ModifyMembershipCommand;
import com.easypay.membershipservice.application.port.in.ModifyMembershipUseCase;
import com.easypay.membershipservice.domain.Membership;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class ModifyMembershipController {

    private final ModifyMembershipUseCase modifyMembershipUseCase;

    @PostMapping("/membership/modify/{membershipId}")
    ResponseEntity<Membership> modifyMembershipById(@RequestBody ModifyMembershipRequest request){
        ModifyMembershipCommand command = ModifyMembershipCommand.builder().
                membershipId(request.getMembershipId())
                .name(request.getName())
                .email(request.getEmail())
                .address(request.getAddress())
                .isCorp(request.isCorp())
                .isValid(request.isValid()).build();
        return ResponseEntity.ok(modifyMembershipUseCase.modifyMembership(command));
    }
}
