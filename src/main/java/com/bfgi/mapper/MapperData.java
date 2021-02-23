package com.bfgi.mapper;

import org.springframework.stereotype.Component;

import com.bfgi.bean.dto.UserDTO;
import com.bfgi.bean.response.DTO.BalanceDTO;

@Component
public class MapperData {
	
	public  BalanceDTO mapBalanceDto(UserDTO user) {
		BalanceDTO balance=new BalanceDTO();
		balance.setUserId(user.getUserId());
		balance.setUserName(user.getUserName());
		balance.setAccountBalance(user.getAccountBalance());
		return balance;
	}

}
