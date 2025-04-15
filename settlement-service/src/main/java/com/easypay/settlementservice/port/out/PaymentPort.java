
package com.easypay.settlementservice.port.out;

import com.easypay.settlementservice.adapter.out.service.Payment;

import java.util.List;

public interface PaymentPort {
    List<Payment> getNormalStatusPayments(); // membershipId = franchiseId 간주.

    // 타겟 계좌, 금액
    void finishSettlement(Long paymentId);
}