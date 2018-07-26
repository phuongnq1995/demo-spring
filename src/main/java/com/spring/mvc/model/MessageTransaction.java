package com.spring.mvc.model;


public class MessageTransaction {
	
    private String from;
    private String text;
    private String when;
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
	public String getWhen() {
		return when;
	}
	public void setWhen(String when) {
		this.when = when;
	}
	public MessageTransaction(String from, String text, String when) {
		super();
		this.from = from;
		this.text = text;
		this.when = when;
	}
    
	public MessageTransaction() {
		
	}
}
