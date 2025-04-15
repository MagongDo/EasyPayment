package com.easypay.moneyservice.application.port.in;

import com.easypay.moneyservice.domain.MemberMoney;
import com.easypay.moneyservice.domain.MoneyChangingRequest;

import java.util.List;

public interface IncreaseMoneyRequestUseCase {
    MoneyChangingRequest increaseMoneyRequest(IncreaseMoneyRequestCommand command);
    MoneyChangingRequest increaseMoneyRequestAsync(IncreaseMoneyRequestCommand command);

    void increaseMoneyRequestByEvent(IncreaseMoneyRequestCommand command);

    List<MemberMoney> findMemberMoneyListByMembershipIds(FindMemberMoneyListByMembershipIdsCommand command);
}
