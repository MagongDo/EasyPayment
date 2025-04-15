package com.easypay.bankingservice.application.port.out;


import com.easypay.bankingservice.adapter.out.external.bank.BankAccount;
import com.easypay.bankingservice.adapter.out.external.bank.GetBankAccountRequest;

public interface RequestBankAccountInfoPort {
    BankAccount getBankAccountInfo(GetBankAccountRequest request);
}
