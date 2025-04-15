package com.easypay.bankingservice.adapter.out.external.bank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BankAccount {
    private String bankName;
    private String bankAccountNumber;
    private boolean isValid;

    public BankAccount(String bankName, String bankAccountNumber, boolean isValid) {
        this.bankName = bankName;
        this.bankAccountNumber = bankAccountNumber;
        this.isValid = isValid;
    }
}
