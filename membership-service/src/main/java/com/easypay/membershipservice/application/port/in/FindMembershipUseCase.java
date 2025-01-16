package com.easypay.membershipservice.application.port.in;


import com.easypay.membershipservice.domain.Membership;

public interface FindMembershipUseCase {

	Membership findMembership(FindMembershipCommand command);
}