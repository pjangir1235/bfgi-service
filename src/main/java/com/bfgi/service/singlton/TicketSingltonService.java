package com.bfgi.service.singlton;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.bfgi.bean.dto.TicketDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class TicketSingltonService {
	
	public static List<TicketDTO> ticketList=new ArrayList<>();
	
	public void loadData() {
		final ObjectMapper objectMapper = new ObjectMapper();
		try {
			ticketList = objectMapper.readValue(this.getClass().getClassLoader().getResource("json/ticket.json"), new TypeReference<List<TicketDTO>>(){});
		} 
		catch (IOException e) {
		}
	}

	public List<TicketDTO> getTicketById(Long userId) {
		return ticketList.stream().filter(ticket->ticket.getUserId().equals(userId)).collect(Collectors.toList());
	}
	public TicketDTO addTicket(TicketDTO ticketRequestDto) {
		ticketRequestDto.setStatus("PENDING");
		ticketRequestDto.setDate(new Date());
		ticketList.add(ticketRequestDto);
		return ticketRequestDto;
		
	}

}
