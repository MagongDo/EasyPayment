package com.easypay.membershipservice.application.port.out;


import com.easypay.membershipservice.adapter.out.persistence.MembershipJpaEntity;
import com.easypay.membershipservice.domain.Membership;


public interface FindMembershipPort {

	MembershipJpaEntity findMembership(
			Membership.MembershipId membershipId
	);
}