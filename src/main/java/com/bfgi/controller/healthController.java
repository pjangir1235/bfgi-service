package com.bfgi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class healthController {

	@GetMapping("/")
	  public String health() {
	    return "Working Fine";
	  }
}
