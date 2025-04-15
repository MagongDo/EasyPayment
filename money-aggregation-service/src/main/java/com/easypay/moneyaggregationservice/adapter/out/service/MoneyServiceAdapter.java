package com.easypay.moneyaggregationservice.adapter.out.service;


import com.easypay.common.CommonHttpClient;
import com.easypay.common.ExternalSystemAdapter;
import com.easypay.moneyaggregationservice.application.port.out.GetMoneySumPort;
import com.easypay.moneyaggregationservice.application.port.out.MemberMoney;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.apache.bcel.classfile.annotation.NameValuePair;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@ExternalSystemAdapter
public class MoneyServiceAdapter implements GetMoneySumPort {

    private final CommonHttpClient moneyServiceHttpClient;

    @Value("${service.money.url}")
    private String moneyServiceEndpoint;

    public MoneyServiceAdapter(CommonHttpClient commonHttpClient,
                                    @Value("${service.money.url}") String moneyServiceEndpoint) {
        this.moneyServiceHttpClient = commonHttpClient;
        this.moneyServiceEndpoint = moneyServiceEndpoint;
    }
    @Override
    public List<MemberMoney> getMoneySumByMembershipIds(List<String> membershipIds) {
        String url = String.join("/", moneyServiceEndpoint, "money/member-money");
        ObjectMapper mapper = new ObjectMapper();

        try {
            FindMemberMoneyRequest request = new FindMemberMoneyRequest(membershipIds);
            String requestBody = mapper.writeValueAsString(request);
            String jsonResponse = moneyServiceHttpClient.sendPostRequest(url, requestBody)
                    .join()   // 또는 .get()
                    .body();
            System.out.println(jsonResponse);
            // 응답을 MemberMoneyResponse 객체로 매핑
            List<MemberMoney> memberMoneyList = mapper.readValue(jsonResponse, new TypeReference<List<MemberMoney>>() {});
            return memberMoneyList;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}