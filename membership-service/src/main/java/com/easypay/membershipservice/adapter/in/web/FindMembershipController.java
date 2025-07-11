package com.easypay.membershipservice.adapter.in.web;


import com.easypay.common.WebAdapter;
import com.easypay.membershipservice.application.port.in.FindMembershipCommand;
import com.easypay.membershipservice.application.port.in.FindMembershipListByAddressCommand;
import com.easypay.membershipservice.application.port.in.FindMembershipUseCase;
import com.easypay.membershipservice.domain.Membership;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@WebAdapter
@RestController
@RequiredArgsConstructor
class FindMembershipController {

	private final FindMembershipUseCase findMembershipUseCase;

	@GetMapping(path = "/membership/{membershipId}")
	ResponseEntity<Membership> findMembershipByMemberId(@PathVariable String membershipId){

		FindMembershipCommand command = FindMembershipCommand.builder()
				.membershipId(membershipId)
				.build();
		return ResponseEntity.ok(findMembershipUseCase.findMembership(command));
	}
	@GetMapping(path = "/membership/address/{addressName}")
	ResponseEntity<List<Membership>> findMembershipListByAddress(@PathVariable String addressName) {
		FindMembershipListByAddressCommand command = FindMembershipListByAddressCommand.builder()
				.addressName(addressName)
				.build();
		return ResponseEntity.ok(findMembershipUseCase.findMembershipListByAddress(command));
	}
}