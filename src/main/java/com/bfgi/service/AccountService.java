package com.bfgi.service;

import com.bfgi.bean.response.DTO.BalanceDTO;
import com.bfgi.bean.response.DTO.PaymentRequestDto;
import com.bfgi.bean.response.DTO.PaymentResponseDto;

public interface AccountService {
	
	public BalanceDTO getBalance(Long userId);

	public PaymentResponseDto doPayment(PaymentRequestDto paymentRequest) throws Exception;

}
