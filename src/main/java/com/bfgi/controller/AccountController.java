package com.bfgi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.bfgi.bean.response.DTO.BalanceDTO;
import com.bfgi.bean.response.DTO.PaymentRequestDto;
import com.bfgi.bean.response.DTO.PaymentResponseDto;
import com.bfgi.service.AccountService;
import com.bfgi.service.singlton.UserSingltonService;

@RestController
public class AccountController {
	
	@Autowired 
	UserSingltonService userService;
	
	@Autowired
	AccountService accountService;
	
	@GetMapping("/balance")
	public ResponseEntity<BalanceDTO> getBalance(@RequestParam("userId") Long userId){
		try {
			userService.checkUser(userId);
			return ResponseEntity.ok(accountService.getBalance(userId));
		} catch (Exception e) {
			throw new ResponseStatusException(
			          HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
	
	@PostMapping("/makePayment")
	public ResponseEntity<PaymentResponseDto> makePayment(@RequestBody PaymentRequestDto paymentRequest){
		try {
			userService.checkUser(paymentRequest.getSourceUserId());
			userService.checkUser(paymentRequest.getTargetUserId());
			return ResponseEntity.ok(accountService.doPayment(paymentRequest));
		} catch (Exception e) {
			throw new ResponseStatusException(
			          HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
	

}
