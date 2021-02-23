package com.bfgi.service.singlton;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bfgi.bean.dto.AppointmentDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class AppointmentSingltonService {
	
	//private static final Logger logger = LoggerFactory.getLogger(AppointmentSingltonService.class);
	public List<AppointmentDTO> appointmentList;
	
	public void loadData() {
		final ObjectMapper objectMapper = new ObjectMapper();
		try {
			appointmentList = objectMapper.readValue(this.getClass().getClassLoader().getResource("json/appointment.json"), new TypeReference<List<AppointmentDTO>>(){});
		} 
		catch (IOException e) {
			//logger.error("AppointmentSingltonService::loadData() unable to fetch data");
		}
	}

}
