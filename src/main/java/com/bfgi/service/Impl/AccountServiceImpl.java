package com.bfgi.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.bfgi.bean.dto.UserDTO;
import com.bfgi.bean.response.DTO.BalanceDTO;
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


}
