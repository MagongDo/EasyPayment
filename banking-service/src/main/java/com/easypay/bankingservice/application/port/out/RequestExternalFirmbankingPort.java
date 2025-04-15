package com.easypay.bankingservice.application.port.out;

import com.easypay.bankingservice.adapter.out.external.bank.ExternalFirmbankingRequest;
import com.easypay.bankingservice.adapter.out.external.bank.FirmbankingResult;

public interface RequestExternalFirmbankingPort {
    FirmbankingResult requestExternalFirmbanking(ExternalFirmbankingRequest request);
}
