package com.easypay.bankingservice.adapter.in.web;


import com.easypay.bankingservice.application.port.in.GetRegisteredBankAccountCommand;
import com.easypay.bankingservice.application.port.in.GetRegisteredBankAccountUseCase;
import com.easypay.bankingservice.domain.RegisteredBankAccount;
import com.easypay.common.WebAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@WebAdapter
@RestController
@RequiredArgsConstructor
public class GetRegisteredBankAccountController {

    private final GetRegisteredBankAccountUseCase getRegisteredBankAccountUseCase;
    @GetMapping(path = "/banking/account/{membershipId}")
    RegisteredBankAccount getRegisteredBankAccount(@PathVariable String membershipId) {
        // 편의상 사용.
        GetRegisteredBankAccountCommand command = GetRegisteredBankAccountCommand.builder().membershipId(membershipId).build();
        return getRegisteredBankAccountUseCase.getRegisteredBankAccount(command);
    }
}