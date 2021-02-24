package com.bfgi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.bfgi.bean.dto.TicketDTO;
import com.bfgi.bean.response.DTO.PaymentRequestDto;
import com.bfgi.bean.response.DTO.PaymentResponseDto;
import com.bfgi.service.singlton.TicketSingltonService;
import com.bfgi.service.singlton.UserSingltonService;

@RestController
public class TicketController {
	
	@Autowired 
	UserSingltonService userService;
	
	@Autowired 
	TicketSingltonService ticketService;
	
	@GetMapping("/getTicket")
	public ResponseEntity<List<TicketDTO>> getBalance(@RequestParam("userId") Long userId){
		try {
			userService.checkUser(userId);
			return ResponseEntity.ok(ticketService.getTicketById(userId));
		} catch (Exception e) {
			throw new ResponseStatusException(
			          HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
	
	@PostMapping("/createTicket")
	public ResponseEntity<TicketDTO> makePayment(@RequestBody TicketDTO ticket){
		try {
			userService.checkUser(ticket.getUserId());
			return ResponseEntity.ok(ticketService.addTicket(ticket));
		} catch (Exception e) {
			throw new ResponseStatusException(
			          HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
	

}
