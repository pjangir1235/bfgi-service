package com.bfgi.service.singlton;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.bfgi.bean.dto.UserDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class UserSingltonService {
	
	//private static final Logger logger = LoggerFactory.getLogger(UserSingltonService.class);
	public static List<UserDTO> userList;
	private UserSingltonService() {}
	
	public void loadData() {
		final ObjectMapper objectMapper = new ObjectMapper();
		try {
			userList = objectMapper.readValue(this.getClass().getClassLoader()
                    .getResourceAsStream("json/user.json"), new TypeReference<List<UserDTO>>(){});
		} 
		catch (IOException e) {
	//		logger.error("UserSingltonService::loadData() unable to fetch data");
		}
	}

	public void checkUser(Long userId) throws Exception {
		if(!userList.stream().anyMatch(user->user.getUserId().equals(userId))) {
		//	logger.error("UserSingltonService::checkUser() unable to get User Data UserId - "+userId);
			throw new Exception("User Id is not Valid");
		}
	}

	public UserDTO getUserDataById(Long userId) {
		return userList.stream().filter(user->user.getUserId().equals(userId)).findFirst().get();
	}

}
