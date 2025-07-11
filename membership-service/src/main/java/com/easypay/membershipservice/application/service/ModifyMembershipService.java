package com.easypay.membershipservice.application.service;



import com.easypay.common.UseCase;
import com.easypay.membershipservice.adapter.out.persistence.MembershipJpaEntity;
import com.easypay.membershipservice.adapter.out.persistence.MembershipMapper;
import com.easypay.membershipservice.application.port.in.ModifyMembershipCommand;
import com.easypay.membershipservice.application.port.in.ModifyMembershipUseCase;
import com.easypay.membershipservice.application.port.out.ModifyMembershipPort;
import com.easypay.membershipservice.domain.Membership;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@UseCase
@Transactional
public class ModifyMembershipService implements ModifyMembershipUseCase {

	private final ModifyMembershipPort modifyMembershipPort;

	private final MembershipMapper membershipMapper;

	@Override
	public Membership modifyMembership(ModifyMembershipCommand command) {
		MembershipJpaEntity jpaEntity = modifyMembershipPort.modifyMembership(
				new Membership.MembershipId(command.getMembershipId()),
				new Membership.MembershipName(command.getName()),
				new Membership.MembershipEmail(command.getEmail()),
				new Membership.MembershipAddress(command.getAddress()),
				new Membership.MembershipIsValid(command.isValid()),
				new Membership.MembershipIsCorp(command.isCorp()),
				new Membership.MembershipRefreshToken("")
		);
		return membershipMapper.mapToDomainEntity(jpaEntity);
	}
}