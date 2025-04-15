package com.easypay.paymentservice.application.port.out;

import com.easypay.paymentservice.domain.Payment;

import java.util.List;

public interface CreatePaymentPort {
    Payment createPayment(String requestMembershipId, String requestPrice, String franchiseId, String franchiseFeeRate);
    List<Payment> getNormalStatusPayments();
    void changePaymentRequestStatus(String paymentId, int status);
}