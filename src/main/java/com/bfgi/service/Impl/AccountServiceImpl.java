package com.bfgi.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.bfgi.bean.dto.UserDTO;
import com.bfgi.bean.response.DTO.BalanceDTO;
import com.bfgi.bean.response.DTO.PaymentRequestDto;
import com.bfgi.bean.response.DTO.PaymentResponseDto;
import com.bfgi.mapper.MapperData;
import com.bfgi.service.AccountService;
import com.bfgi.service.singlton.UserSingltonService;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	UserSingltonService userService;
	
	@Autowired
	MapperData mapper;
	
	@Override
	public BalanceDTO getBalance(Long userId) {
		UserDTO userData=userService.getUserDataById(userId);
		return mapper.mapBalanceDto(userData);
	}

	@Override
	public PaymentResponseDto doPayment(PaymentRequestDto paymentRequest) throws Exception {
		UserDTO sourceUser=userService.getUserDataById(paymentRequest.getSourceUserId());
		if(sourceUser.getAccountBalance()>=paymentRequest.getAmount()) {
			Double balance=sourceUser.getAccountBalance()-paymentRequest.getAmount();
			UserDTO targetUser=userService.getUserDataById(paymentRequest.getSourceUserId());
			userService.updateBalance(paymentRequest.getSourceUserId(),sourceUser.getAccountBalance()-paymentRequest.getAmount());
			userService.updateBalance(paymentRequest.getTargetUserId(),targetUser.getAccountBalance()+paymentRequest.getAmount());
			return mapper.mapPayment(paymentRequest,balance);
		}
		throw new Exception("Insufficient Balance! Transaction Decline");
	}


}
