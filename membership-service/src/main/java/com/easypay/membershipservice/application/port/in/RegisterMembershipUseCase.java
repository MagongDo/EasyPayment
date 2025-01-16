package com.easypay.membershipservice.application.port.in;


import com.easypay.membershipservice.domain.Membership;

public interface RegisterMembershipUseCase {

    Membership registerMembership(RegisterMembershipCommand command);
}
