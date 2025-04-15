package com.easypay.paymentservice.application.service;

import com.easypay.common.UseCase;
import com.easypay.paymentservice.application.port.in.FinishSettlementCommand;
import com.easypay.paymentservice.application.port.in.RequestPaymentCommand;
import com.easypay.paymentservice.application.port.in.RequestPaymentUseCase;
import com.easypay.paymentservice.application.port.out.CreatePaymentPort;
import com.easypay.paymentservice.application.port.out.GetMembershipPort;
import com.easypay.paymentservice.application.port.out.GetRegisteredBankAccountPort;
import com.easypay.paymentservice.domain.Payment;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@UseCase
@RequiredArgsConstructor
@Transactional
public class PaymentService implements RequestPaymentUseCase {

    private final CreatePaymentPort createPaymentPort;

    private final GetMembershipPort getMembershipPort;
    private final GetRegisteredBankAccountPort getRegisteredBankAccountPort;

    // Todo Money Service -> Member Money 정보를 가져오기 위한 Port

    @Override
    public Payment requestPayment(RequestPaymentCommand command) {

        // 충전도, 멤버십, 머니 유효성 확인.....
        // getMembershipPort.getMembership(command.getRequestMembershipId());

        //getRegisteredBankAccountPort.getRegisteredBankAccount(command.getRequestMembershipId());

        //....

        // createPaymentPort
        return createPaymentPort.createPayment(
                command.getRequestMembershipId(),
                command.getRequestPrice(),
                command.getFranchiseId(),
                command.getFranchiseFeeRate());
    }
    @Override
    public List<Payment> getNormalStatusPayments() {
        return createPaymentPort.getNormalStatusPayments();
    }

    @Override
    public void finishPayment(FinishSettlementCommand command) {
        createPaymentPort.changePaymentRequestStatus(command.getPaymentId(), 2);
    }
}