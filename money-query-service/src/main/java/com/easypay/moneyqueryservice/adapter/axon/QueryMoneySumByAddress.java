package com.easypay.moneyqueryservice.adapter.axon;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QueryMoneySumByAddress {
    private String address;
}