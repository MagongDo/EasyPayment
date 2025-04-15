package com.easypay.moneyqueryservice.application.service;


import com.easypay.common.UseCase;
import com.easypay.moneyqueryservice.adapter.axon.QueryMoneySumByAddress;
import com.easypay.moneyqueryservice.application.port.in.QueryMoneySumByRegionQuery;
import com.easypay.moneyqueryservice.application.port.in.QueryMoneySumByRegionUseCase;
import com.easypay.moneyqueryservice.domain.MoneySumByRegion;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.ExecutionException;

@UseCase
@RequiredArgsConstructor
@Transactional
public class QueryMoneySumByRegionService implements QueryMoneySumByRegionUseCase {
    private final QueryGateway queryGateway;
    @Override
    public MoneySumByRegion queryMoneySumByRegion(QueryMoneySumByRegionQuery query) {
        try {
            return queryGateway.query(new QueryMoneySumByAddress(query.getAddress())
                    , MoneySumByRegion.class).get();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}