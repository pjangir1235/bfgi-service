package com.bfgi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.bfgi.bean.response.DTO.BalanceDTO;
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
			          HttpStatus.NOT_FOUND, e.getMessage());
		}
	}
	

}
