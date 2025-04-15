package com.easypay.moneyservice.application.port.out;


import com.easypay.moneyservice.domain.MemberMoney;

public interface CreateMemberMoneyPort {
    void createMemberMoney(
            MemberMoney.MembershipId memberId,
            MemberMoney.MoneyAggregateIdentifier aggregateIdentifier
    );
}