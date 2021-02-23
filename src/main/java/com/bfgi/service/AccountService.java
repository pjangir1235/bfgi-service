package com.bfgi.service;

import com.bfgi.bean.response.DTO.BalanceDTO;

public interface AccountService {
	
	public BalanceDTO getBalance(Long userId);

}
