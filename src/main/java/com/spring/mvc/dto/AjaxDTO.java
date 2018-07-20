package com.spring.mvc.dto;

import javax.validation.constraints.NotEmpty;

public class AjaxDTO {

	@NotEmpty
	private String customerName;

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
}
