package com.easypay.paymentservice.application.port.out;

public interface GetMembershipPort {
    public MembershipStatus getMembership(String membershipId);
}