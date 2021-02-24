package com.bfgi.mapper;

import org.springframework.stereotype.Component;

import com.bfgi.bean.dto.UserDTO;
import com.bfgi.bean.response.DTO.BalanceDTO;
import com.bfgi.bean.response.DTO.PaymentRequestDto;
import com.bfgi.bean.response.DTO.PaymentResponseDto;

@Component
public class MapperData {
	
	public  BalanceDTO mapBalanceDto(UserDTO user) {
		BalanceDTO balance=new BalanceDTO();
		balance.setUserId(user.getUserId());
		balance.setUserName(user.getUserName());
		balance.setAccountBalance(user.getAccountBalance());
		return balance;
	}

	public PaymentResponseDto mapPayment(PaymentRequestDto paymentRequest, Double balance) {
		PaymentResponseDto payment=new PaymentResponseDto();
		payment.setSourceUserId(paymentRequest.getSourceUserId());
		payment.setTargetUserId(paymentRequest.getTargetUserId());
		payment.setAmount(paymentRequest.getAmount());
		payment.setBalance(balance);
		return payment;
	}

}
