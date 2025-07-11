package com.easypay.remittanceservice.adapter.in;

import com.easypay.common.WebAdapter;
import com.easypay.remittanceservice.application.port.in.RequestRemittanceCommand;
import com.easypay.remittanceservice.application.port.in.RequestRemittanceUseCase;
import com.easypay.remittanceservice.domain.RemittanceRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class RequestRemittanceController {

    private final RequestRemittanceUseCase requestRemittanceUseCase;

    @PostMapping(path = "/remittance/request")
    RemittanceRequest requestRemittance(@RequestBody RequestRemittanceRequest request) {
        RequestRemittanceCommand command = RequestRemittanceCommand.builder()
                .fromMembershipId(request.getFromMembershipId())
                .toMembershipId(request.getToMembershipId())
                .toBankName(request.getToBankName())
                .toBankAccountNumber(request.getToBankAccountNumber())
                .amount(request.getAmount())
                .remittanceType(request.getRemittanceType())
                .build();

        return requestRemittanceUseCase.requestRemittance(command);
    }
}