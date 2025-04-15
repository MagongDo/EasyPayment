package com.easypay.bankingservice.adapter.out.persistence;


import com.easypay.bankingservice.application.port.out.RequestFirmbankingPort;
import com.easypay.bankingservice.domain.FirmbankingRequest;
import com.easypay.common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

@PersistenceAdapter
@RequiredArgsConstructor
public class FirmbankingRequestPersistenceAdapter implements RequestFirmbankingPort {

    private final SpringDataFirmbankingRequestRepository firmbankingRequestRepository;


    @Override
    public FirmbankingRequestJpaEntity createFirmbankingRequest(FirmbankingRequest.FromBankName fromBankName, FirmbankingRequest.FromBankAccountNumber fromBankAccountNumber, FirmbankingRequest.ToBankName toBankName, FirmbankingRequest.ToBankAccountNumber toBankAccountNumber, FirmbankingRequest.MoneyAmount moneyAmount, FirmbankingRequest.FirmbankingStatus firmbankingStatus, FirmbankingRequest.FirmbankingAggregateIdentifier firmbankingAggregateIdentifier) {
        return firmbankingRequestRepository.save(new FirmbankingRequestJpaEntity(
                        fromBankName.getFromBankName(),
                        fromBankAccountNumber.getFromBankAccountNumber(),
                        toBankName.getToBankName(),
                        toBankAccountNumber.getToBankAccountNumber(),
                        moneyAmount.getMoneyAmount(), firmbankingStatus.getFirmBankingStatus(),
                        UUID.randomUUID(),
                        firmbankingAggregateIdentifier.getAggregateIdentifier()
                )
        );
    }

    @Override
    public FirmbankingRequestJpaEntity modifyFirmbankingRequest(FirmbankingRequestJpaEntity entity) {
        return firmbankingRequestRepository.save(entity);
    }

    @Override
    public FirmbankingRequestJpaEntity getFirmbankingRequest(FirmbankingRequest.FirmbankingAggregateIdentifier firmbankingAggregateIdentifier) {
        List<FirmbankingRequestJpaEntity> entityList =  firmbankingRequestRepository.findByAggregateIdentifier(firmbankingAggregateIdentifier.getAggregateIdentifier());
        if(entityList.size() > 0) {
            return entityList.get(0);
        }
        return null;
    }
}