package com.easypay.membershipservice.application.port.out;


import com.easypay.membershipservice.adapter.out.persistence.MembershipJpaEntity;
import com.easypay.membershipservice.domain.Membership;

import java.util.List;


public interface FindMembershipPort {

	MembershipJpaEntity findMembership(
			Membership.MembershipId membershipId
	);
	List<MembershipJpaEntity> findMembershipListByAddress(
			Membership.MembershipAddress membershipAddress
	);
}