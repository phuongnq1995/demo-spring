package com.spring.mvc.model;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="address")
@Entity
public class AddressEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3925464634025822918L;

	@Id 
	private String id;

	@Column
	private String name;
	
	@Column
	private String customerId;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

}
