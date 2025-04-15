package com.easypay.moneyservice.application.port.out;



public interface GetMembershipPort {
    public MembershipStatus getMembership(String membershipId);
}
