package com.easypay.remittanceservice.application.port.out.banking;


public interface BankingPort {

    BankingInfo getMembershipBankingInfo(String bankName, String bankAccountNumber);

    boolean requestFirmbanking(String bankName, String bankAccountNumber, int amount);
}