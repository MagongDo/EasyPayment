package com.easypay.membershipservice.application.service;


import com.easypay.membershipservice.adapter.out.persistence.MembershipJpaEntity;
import com.easypay.membershipservice.adapter.out.persistence.MembershipMapper;
import com.easypay.membershipservice.application.port.in.FindMembershipCommand;
import com.easypay.membershipservice.application.port.in.FindMembershipUseCase;
import com.easypay.membershipservice.application.port.out.FindMembershipPort;
import com.easypay.membershipservice.domain.Membership;
import common.UseCase;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@UseCase
@Transactional
public class FindMembershipService implements FindMembershipUseCase {

	private final FindMembershipPort fport;

	private final MembershipMapper membershipMapper;
	@Override
	public Membership findMembership(FindMembershipCommand command) {
		MembershipJpaEntity entity = fport.findMembership(new Membership.MembershipId(command.getMembershipId()));
		return membershipMapper.mapToDomainEntity(entity);
	}

}