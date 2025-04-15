package com.easypay.moneyaggregationservice.adapter.in.web;

import com.easypay.common.WebAdapter;
import com.easypay.moneyaggregationservice.application.port.in.GetMoneySumByAddressCommand;
import com.easypay.moneyaggregationservice.application.port.in.GetMoneySumByAddressUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@WebAdapter
@RestController
@RequiredArgsConstructor
public class GetMoneySumController {
    private final GetMoneySumByAddressUseCase getMoneySumByAddressUseCase;
    @PostMapping(path = "/money/aggregation/get-money-sum-by-address")
    int getMoneySumByAddress(@RequestBody GetMoneySumByAddressRequest request) {
//        StopWatch stopWatch = new StopWatch();
//        stopWatch.start();
//        stopWatch.stop();
//        System.out.println("경과 시간(밀리초): " + stopWatch.getTotalTimeMillis());

        return getMoneySumByAddressUseCase.getMoneySumByAddress(
                GetMoneySumByAddressCommand.builder()
                        .address(request.getAddress()).build()
        );
    }
}