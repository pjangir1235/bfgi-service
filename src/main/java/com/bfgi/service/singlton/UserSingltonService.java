package com.bfgi.service.singlton;

import java.io.IOException;
import java.util.List;

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
		}
	}

	public void checkUser(Long userId) throws Exception {
		if(!userList.stream().anyMatch(user->user.getUserId().equals(userId))) {
			throw new Exception("User Id is not Valid");
		}
	}

	public UserDTO getUserDataById(Long userId) {
		return userList.stream().filter(user->user.getUserId().equals(userId)).findFirst().get();
	}

	public void updateBalance(Long sourceUserId, double d) {
		System.out.println("1");
		userList.forEach(user->{
			if(sourceUserId.equals(user.getUserId())) {
				System.out.println("d : "+ d + user );
				user.setAccountBalance(d);
			}
		});
	}

}
