package com.easypay.moneyqueryservice.application.port.out;

import java.util.Date;

public interface GetMoneySumByAddressPort {
    int getMoneySumByAddress(String addressName);
}