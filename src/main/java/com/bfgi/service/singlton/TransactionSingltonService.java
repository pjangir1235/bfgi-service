package com.bfgi.service.singlton;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Component;

import com.bfgi.bean.dto.TransactionDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class TransactionSingltonService {
	
	//private static final Logger logger = LoggerFactory.getLogger(TransactionSingltonService.class);
	public List<TransactionDTO> transactionList;
	
	public void loadData() {
		final ObjectMapper objectMapper = new ObjectMapper();
		try {
			transactionList = objectMapper.readValue(this.getClass().getClassLoader().getResource("json/transaction.json"), new TypeReference<List<TransactionDTO>>(){});
		} 
		catch (IOException e) {
		//	logger.error("TransactionSingltonService::loadData() unable to fetch data");
		}
	}

}
