package com.easypay.moneyservice.application.port.out;


import com.easypay.moneyservice.adapter.out.persistence.MemberMoneyJpaEntity;
import com.easypay.moneyservice.domain.MemberMoney;

public interface GetMemberMoneyPort {
    MemberMoneyJpaEntity getMemberMoney(
            MemberMoney.MembershipId memberId
    );
}