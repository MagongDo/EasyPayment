package com.easypay.moneyservice.application.port.out;


import com.easypay.moneyservice.adapter.out.persistence.MemberMoneyJpaEntity;

import java.util.List;

public interface GetMemberMoneyListPort {
    List<MemberMoneyJpaEntity> getMemberMoneyPort(List<String> membershipIds);
}