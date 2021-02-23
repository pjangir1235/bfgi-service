package com.bfgi;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bfgi.service.singlton.AppointmentSingltonService;
import com.bfgi.service.singlton.SecurityQnaSingltonService;
import com.bfgi.service.singlton.TicketSingltonService;
import com.bfgi.service.singlton.TransactionSingltonService;
import com.bfgi.service.singlton.UserSingltonService;

@SpringBootApplication
public class SpringbootApplication {

	@Autowired
	AppointmentSingltonService appointmentService;

	@Autowired
	SecurityQnaSingltonService secuirityQnaService;

	@Autowired
	TicketSingltonService ticketService;

	@Autowired
	TransactionSingltonService transactionService;

	@Autowired
	UserSingltonService userService;
	
  public static void main(String[] args) {
    SpringApplication.run(SpringbootApplication.class, args);
  }

  @PostConstruct
private void init() {
	appointmentService.loadData();
	secuirityQnaService.loadData();
	ticketService.loadData();
	transactionService.loadData();
	userService.loadData();
}

  

}
