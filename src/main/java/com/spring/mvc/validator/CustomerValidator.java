package com.spring.mvc.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import com.spring.mvc.dto.CustomerDTO;
import com.spring.mvc.service.CustomerService;

@Component
public class CustomerValidator implements Validator {

	@Autowired
	CustomerService service;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return CustomerDTO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		CustomerDTO customerDTO = (CustomerDTO) target;
		if(service.checkExistsName(customerDTO.getName())) {
			errors.rejectValue("name", "demo.valid.name.exists");
		}
	}

}
