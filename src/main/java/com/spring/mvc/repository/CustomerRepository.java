package com.spring.mvc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.mvc.model.CustomerEntity;

public interface CustomerRepository extends JpaRepository<CustomerEntity, String>{

	List<CustomerEntity> findByName(String name);

}
