package com.souramandala.exception;

public class CustomerException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private String message;

	public CustomerException(String message) {
		
		this.message = message;
	}

	@Override
	public String getMessage() {
		return this.message;
	}
	
	

	
}
