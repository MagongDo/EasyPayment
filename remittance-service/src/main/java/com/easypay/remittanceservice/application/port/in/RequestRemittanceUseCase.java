package com.easypay.remittanceservice.application.port.in;


import com.easypay.remittanceservice.domain.RemittanceRequest;

public interface RequestRemittanceUseCase {
    RemittanceRequest requestRemittance(RequestRemittanceCommand command);
}