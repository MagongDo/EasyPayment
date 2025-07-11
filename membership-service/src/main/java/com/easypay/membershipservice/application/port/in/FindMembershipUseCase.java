package com.easypay.membershipservice.application.port.in;


import com.easypay.membershipservice.domain.Membership;

import java.util.List;

public interface FindMembershipUseCase {

	Membership findMembership(FindMembershipCommand command);

	List<Membership> findMembershipListByAddress(FindMembershipListByAddressCommand command);
}