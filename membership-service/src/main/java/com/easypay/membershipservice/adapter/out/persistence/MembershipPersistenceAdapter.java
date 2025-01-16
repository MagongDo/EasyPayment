package com.easypay.membershipservice.adapter.out.persistence;

import com.easypay.membershipservice.application.port.out.FindMembershipPort;
import com.easypay.membershipservice.application.port.out.RegisterMembershipPort;
import com.easypay.membershipservice.domain.Membership;
import common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class MembershipPersistenceAdapter implements RegisterMembershipPort, FindMembershipPort {
    private final SpringDataMembershipRepository membershipRepository;
    @Override
    public MembershipJpaEntity createMembership(Membership.MembershipName membershipName,
                                 Membership.MembershipEmail membershipEmail,
                                 Membership.MembershipAddress membershipAddress,
                                 Membership.MembershipIsValid membershipIsValid,
                                 Membership.MembershipIsCorp membershipIsCorp) {

       return membershipRepository.save(
                new MembershipJpaEntity(
                        membershipName.getNameValue(),
                        membershipAddress.getAddressValue(),
                        membershipEmail.getEmailValue(),
                        membershipIsValid.isValidValue(),
                        membershipIsCorp.isCorp()
                )
        );
    }

    @Override
    public MembershipJpaEntity findMembership(Membership.MembershipId membershipId) {
        return membershipRepository.getById(Long.parseLong(membershipId.getMembershipId()));
    }
}

