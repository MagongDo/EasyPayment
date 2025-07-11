package com.easypay.membershipservice.application.port.out;

import com.easypay.membershipservice.adapter.out.persistence.MembershipJpaEntity;
import com.easypay.membershipservice.domain.Membership;

public interface RegisterMembershipPort {

    MembershipJpaEntity createMembership(Membership.MembershipName membershipName,
                                         Membership.MembershipEmail membershipEmail,
                                         Membership.MembershipAddress membershipAddress,
                                         Membership.MembershipIsValid membershipIsValid,
                                         Membership.MembershipIsCorp membershipIsCorp);
}
