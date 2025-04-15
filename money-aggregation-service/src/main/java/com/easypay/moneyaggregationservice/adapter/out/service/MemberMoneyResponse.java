package com.easypay.moneyaggregationservice.adapter.out.service;

import com.easypay.moneyaggregationservice.application.port.out.MemberMoney;
import java.util.List;

public class MemberMoneyResponse {
    private List<MemberMoney> memberMoneyList;

    public MemberMoneyResponse() {
    }

    public List<MemberMoney> getMemberMoneyList() {
        return memberMoneyList;
    }

    public void setMemberMoneyList(List<MemberMoney> memberMoneyList) {
        this.memberMoneyList = memberMoneyList;
    }
}