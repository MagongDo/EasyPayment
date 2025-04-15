package com.easypay.remittanceservice.application.port.out;


import com.easypay.remittanceservice.adapter.out.persistence.RemittanceRequestJpaEntity;
import com.easypay.remittanceservice.application.port.in.FindRemittanceCommand;

import java.util.List;

public interface FindRemittancePort {

    List<RemittanceRequestJpaEntity> findRemittanceHistory(FindRemittanceCommand command);
}