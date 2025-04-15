package com.easypay.moneyservice.adapter.in.web;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class IncreaseMoneyChangingRequest {
    private String targetMembershipId;
    private int amount;
}
