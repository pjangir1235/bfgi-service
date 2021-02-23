package com.bfgi.service.singlton;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Component;

import com.bfgi.bean.dto.TicketDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class TicketSingltonService {
	
	//private static final Logger logger = LoggerFactory.getLogger(TicketSingltonService.class);
	public List<TicketDTO> ticketList;
	
	public void loadData() {
		final ObjectMapper objectMapper = new ObjectMapper();
		try {
			ticketList = objectMapper.readValue(this.getClass().getClassLoader().getResource("json/ticket.json"), new TypeReference<List<TicketDTO>>(){});
		} 
		catch (IOException e) {
		//	logger.error("TicketSingltonService::loadData() unable to fetch data");
		}
	}

}
