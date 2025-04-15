package com.easypay.remittanceservice.adapter.in;


import com.easypay.common.WebAdapter;
import com.easypay.remittanceservice.application.port.in.FindRemittanceCommand;
import com.easypay.remittanceservice.application.port.in.FindRemittanceUseCase;
import com.easypay.remittanceservice.domain.RemittanceRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@WebAdapter
@RestController
@RequiredArgsConstructor
public class FindRemittanceHistoryController {

    private final FindRemittanceUseCase findRemittanceUseCase;
    @GetMapping( "/remittance/{membershipId}")
    List<RemittanceRequest> findRemittanceHistory(@PathVariable String membershipId) {
        FindRemittanceCommand command = FindRemittanceCommand.builder()
                .membershipId(membershipId)
                .build();

        return findRemittanceUseCase.findRemittanceHistory(command);
    }
}