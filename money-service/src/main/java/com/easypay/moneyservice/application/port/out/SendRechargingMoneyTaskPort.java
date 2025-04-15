package com.easypay.moneyservice.application.port.out;


import com.easypay.common.RechargingMoneyTask;

public interface SendRechargingMoneyTaskPort {
    void sendRechargingMoneyTaskPort(
            RechargingMoneyTask task
    );
}