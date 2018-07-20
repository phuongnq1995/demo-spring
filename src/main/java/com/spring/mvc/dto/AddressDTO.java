package com.spring.mvc.dto;

import javax.validation.constraints.NotEmpty;

public class AddressDTO {

	@NotEmpty
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
