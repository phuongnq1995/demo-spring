package com.spring.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import com.spring.mvc.model.MessageTransaction;
import com.spring.mvc.service.CustomerService;

import reactor.core.publisher.Flux;

@org.springframework.web.bind.annotation.RestController("/rest")
public class RestController {

	@Autowired
	CustomerService customerService;
	
	@GetMapping
	Flux<MessageTransaction> list() {
		return customerService.getCustomerFlux();
	}
}
