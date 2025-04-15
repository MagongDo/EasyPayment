package com.easypay.moneyservice.application.port.out;


import com.easypay.moneyservice.adapter.out.persistence.MemberMoneyJpaEntity;
import com.easypay.moneyservice.adapter.out.persistence.MoneyChangingRequestJpaEntity;
import com.easypay.moneyservice.domain.MemberMoney;
import com.easypay.moneyservice.domain.MoneyChangingRequest;

public interface IncreaseMoneyPort {

    MoneyChangingRequestJpaEntity createMoneyChangingRequest(
            MoneyChangingRequest.TargetMembershipId targetMembershipId,
            MoneyChangingRequest.MoneyChangingType moneyChangingType,
            MoneyChangingRequest.ChangingMoneyAmount changingMoneyAmount,
            MoneyChangingRequest.MoneyChangingStatus moneyChangingStatus,
            MoneyChangingRequest.Uuid uuid
    );

    MemberMoneyJpaEntity increaseMoney(
            MemberMoney.MembershipId memberId,
            int increaseMoneyAmount
    );
}
