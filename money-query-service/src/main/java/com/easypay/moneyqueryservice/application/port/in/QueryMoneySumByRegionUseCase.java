package com.easypay.moneyqueryservice.application.port.in;


import com.easypay.moneyqueryservice.domain.MoneySumByRegion;

public interface QueryMoneySumByRegionUseCase {

    MoneySumByRegion queryMoneySumByRegion (QueryMoneySumByRegionQuery query);
}