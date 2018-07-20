package com.spring.mvc.service;

import java.util.List;

import com.spring.mvc.model.CustomerEntity;

public interface CustomerService {

	public CustomerEntity select (String id);

	public void create (Object entity) throws Exception;

	public boolean checkExistsName(String name);
	
	public CustomerEntity getCustomerByName(String name) throws Exception;

	public List<CustomerEntity> findAll();
}
