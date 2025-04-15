package com.easypay.bankingservice.adapter.in.web;

import com.easypay.bankingservice.application.port.in.FindRegisterBankAccountCommand;
import com.easypay.bankingservice.application.port.in.FindRegisterBankAccountUseCase;
import com.easypay.common.WebAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
class FindBankingAccountInfoController {

	 private final FindRegisterBankAccountUseCase findRegisterBankingAccountUseCase;

	@GetMapping(path = "/banking/registered-banking-account/{membershipId}")
	ResponseEntity<Object>  findRegisteredBankingAccountByMemberId(@PathVariable String membershipId){

		FindRegisterBankAccountCommand command = FindRegisterBankAccountCommand.builder()
				.membershipId(membershipId).build();

		return ResponseEntity.ok(findRegisterBankingAccountUseCase.findRegisteredBankAccount(command));

	}

	/*@GetMapping(path = "/banking/transfer-money/")
	ResponseEntity<Object>  findTransferMoneyInfoByMemberId(){
		// RegisterMembershipRequest
		// name, address, email

		return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
	}

	@GetMapping(path = "/banking/transfer-money-info/")
	ResponseEntity<Object>  findTransferMoneyInfoByBankingId(){
		// RegisterMembershipRequest
		// name, address, email

		return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
	}*/

}