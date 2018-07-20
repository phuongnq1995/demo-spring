package com.spring.mvc.helper;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.stereotype.Component;
import com.spring.mvc.dto.CustomerDTO;

@Component
public class CustomerHelper {
	
	final static SimpleDateFormat DF = new SimpleDateFormat("dd/MM/yyyy");

	public void populatorCustomer(CustomerDTO customerDTO) {
		customerDTO.setEmail("phuongnq.itedu@gmail.com");
		customerDTO.setName("PhuongNQ");
		customerDTO.setBirthDay(new Date());
	}

}
