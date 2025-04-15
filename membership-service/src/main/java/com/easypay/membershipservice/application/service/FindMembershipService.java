package com.easypay.membershipservice.application.service;



import com.easypay.common.UseCase;
import com.easypay.membershipservice.adapter.out.persistence.MembershipJpaEntity;
import com.easypay.membershipservice.adapter.out.persistence.MembershipMapper;
import com.easypay.membershipservice.application.port.in.FindMembershipCommand;
import com.easypay.membershipservice.application.port.in.FindMembershipListByAddressCommand;
import com.easypay.membershipservice.application.port.in.FindMembershipUseCase;
import com.easypay.membershipservice.application.port.out.FindMembershipPort;
import com.easypay.membershipservice.domain.Membership;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@UseCase
@Transactional
public class FindMembershipService implements FindMembershipUseCase {

	private final FindMembershipPort findMembershipPort;

	private final MembershipMapper membershipMapper;
	@Override
	public Membership findMembership(FindMembershipCommand command) {
		MembershipJpaEntity entity = findMembershipPort.findMembership(new Membership.MembershipId(command.getMembershipId()));
		return membershipMapper.mapToDomainEntity(entity);
	}

	@Override
	public List<Membership> findMembershipListByAddress(FindMembershipListByAddressCommand command) {
		List<MembershipJpaEntity> membershipJpaEntities = findMembershipPort.findMembershipListByAddress(new Membership.MembershipAddress(command.getAddressName()));
		List<Membership> memberships = new ArrayList<>();

		for (MembershipJpaEntity membershipJpaEntity : membershipJpaEntities) {
			memberships.add(membershipMapper.mapToDomainEntity(membershipJpaEntity));
		}
		return memberships;
	}
}