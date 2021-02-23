package com.bfgi.service.singlton;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Component;

import com.bfgi.bean.dto.SecurityQnaDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class SecurityQnaSingltonService {
	
	//private static final Logger logger = LoggerFactory.getLogger(SecurityQnaSingltonService.class);
	public List<SecurityQnaDTO> securityQnaList;
	
	public void loadData() {
		final ObjectMapper objectMapper = new ObjectMapper();
		try {
			securityQnaList = objectMapper.readValue(this.getClass().getClassLoader().getResource("json/securityQna.json"), new TypeReference<List<SecurityQnaDTO>>(){});
		} 
		catch (IOException e) {
			//logger.error("SecurityQnaSingltonService::loadData() unable to fetch data");
		}
	}

}
