package com.spring.mvc.dto;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

public class CustomerDTO {

	@Size(min=2, max=30)
	private String name;

	@Email(message="{demo.valid.email}")
	private String email;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date birthDay;

	@NotEmpty
	@Valid
	private List<AddressDTO> listAddress;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	public List<AddressDTO> getListAddress() {
		return listAddress;
	}

	public void setListAddress(List<AddressDTO> listAddress) {
		this.listAddress = listAddress;
	}

	@Override
	public String toString() {
		return "CustomerDTO [name=" + name + ", email=" + email + ", birthDay=" + birthDay + ", listAddress="
				+ listAddress + "]";
	}

}
