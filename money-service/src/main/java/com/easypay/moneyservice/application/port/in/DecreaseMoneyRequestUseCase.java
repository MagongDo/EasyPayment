package com.easypay.moneyservice.application.port.in;

import com.easypay.moneyservice.domain.MoneyChangingRequest;

public interface DecreaseMoneyRequestUseCase {
    MoneyChangingRequest decreaseMoneyRequest(DecreaseMoneyRequestCommand command);
}
