package com.spring.mvc.model;

import java.util.Date;

public class MessageTransaction {
	
    private String from;
    private String text;
    private Date when;
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Date getWhen() {
		return when;
	}
	public void setWhen(Date when) {
		this.when = when;
	}
	public MessageTransaction(String from, String text, Date when) {
		super();
		this.from = from;
		this.text = text;
		this.when = when;
	}
    
	public MessageTransaction() {
		
	}
}
