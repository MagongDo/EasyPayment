package com.easypay.bankingservice.application.port.in;


import com.easypay.bankingservice.domain.FirmbankingRequest;

public interface RequestFirmbankingUseCase {
    FirmbankingRequest requestFirmbanking(RequestFirmbankingCommand command);
    void requestFirmbankingByEvent(RequestFirmbankingCommand command);
}