package com.easypay.remittanceservice.application.port.out.money;

import lombok.Data;

//  송금서비스에서 필요한 머니의 정보
@Data
public class MoneyInfo {

    private String membershipId;
    private int balance;

    public MoneyInfo(String membershipId, int balance) {
        this.membershipId = membershipId;
        this.balance = balance;
    }
}