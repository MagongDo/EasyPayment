package com.easypay.remittanceservice.application.port.out;


import com.easypay.remittanceservice.adapter.out.persistence.RemittanceRequestJpaEntity;
import com.easypay.remittanceservice.application.port.in.RequestRemittanceCommand;

public interface RequestRemittancePort {

    RemittanceRequestJpaEntity createRemittanceRequestHistory(RequestRemittanceCommand command);
    boolean saveRemittanceRequestHistory(RemittanceRequestJpaEntity entity);
}