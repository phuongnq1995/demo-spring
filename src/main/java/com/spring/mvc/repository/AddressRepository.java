package com.spring.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.mvc.model.AddressEntity;

public interface AddressRepository extends JpaRepository<AddressEntity, String>{

}
