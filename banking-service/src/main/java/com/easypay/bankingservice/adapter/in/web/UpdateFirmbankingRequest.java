package com.easypay.bankingservice.adapter.in.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateFirmbankingRequest {
    private String firmbankingRequestAggregateIdentifier;
    private int status;

}