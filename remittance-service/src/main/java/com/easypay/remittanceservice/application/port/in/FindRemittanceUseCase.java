package com.easypay.remittanceservice.application.port.in;



import com.easypay.remittanceservice.domain.RemittanceRequest;

import java.util.List;

public interface FindRemittanceUseCase {
    List<RemittanceRequest> findRemittanceHistory(FindRemittanceCommand command);
}