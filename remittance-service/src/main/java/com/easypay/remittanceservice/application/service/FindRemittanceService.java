package com.easypay.remittanceservice.application.service;


import com.easypay.common.UseCase;
import com.easypay.remittanceservice.adapter.out.persistence.RemittanceRequestMapper;
import com.easypay.remittanceservice.application.port.in.FindRemittanceCommand;
import com.easypay.remittanceservice.application.port.in.FindRemittanceUseCase;
import com.easypay.remittanceservice.application.port.out.FindRemittancePort;
import com.easypay.remittanceservice.domain.RemittanceRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@UseCase
@RequiredArgsConstructor
@Transactional
public class FindRemittanceService implements FindRemittanceUseCase {
    private final FindRemittancePort findRemittancePort;
    private final RemittanceRequestMapper mapper;

    @Override
    public List<RemittanceRequest> findRemittanceHistory(FindRemittanceCommand command) {
        //
        findRemittancePort.findRemittanceHistory(command);
        return null;
    }
}