package com.easypay.membershipservice.application.service;

import com.easypay.common.UseCase;
import com.easypay.membershipservice.adapter.out.persistence.MembershipJpaEntity;
import com.easypay.membershipservice.adapter.out.persistence.MembershipMapper;
import com.easypay.membershipservice.application.port.in.RegisterMembershipCommand;
import com.easypay.membershipservice.application.port.in.RegisterMembershipUseCase;
import com.easypay.membershipservice.application.port.out.RegisterMembershipPort;
import com.easypay.membershipservice.domain.Membership;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@RequiredArgsConstructor
@Transactional
public class RegisterMembershipService implements RegisterMembershipUseCase {

    private final RegisterMembershipPort registerMembershipPort;
    private final MembershipMapper membershipMapper;
    @Override
    public Membership registerMembership(RegisterMembershipCommand command) {
        // ??
        // command -> DB
        // biz logic -> DB
        //external system
        // port, adapter

       MembershipJpaEntity jpaEntity = registerMembershipPort.createMembership(
                new Membership.MembershipName(command.getName()),
                new Membership.MembershipEmail(command.getEmail()),
                new Membership.MembershipAddress(command.getAddress()),
                new Membership.MembershipIsValid(command.isValid()),
                new Membership.MembershipIsCorp(command.isCorp())

        );

        return membershipMapper.mapToDomainEntity(jpaEntity);
    }


}
