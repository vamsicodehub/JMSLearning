package com.springsms.demo.model;

public class SMSModel {

	private String receiver;
	private String message;

	public SMSModel(String receiver, String message) {
		super();
		this.receiver = receiver;
		this.message = message;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
