package com.easypay.moneyqueryservice.application.port.out;

public interface GetMemberAddressInfoPort {
    MemberAddressInfo getMemberAddressInfo(
            String membershipId
    );
}