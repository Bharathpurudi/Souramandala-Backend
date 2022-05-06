package com.souramandala.exception;

public class OrderException extends RuntimeException {
	
private static final long serialVersionUID = 1L;
	
	private String message;

	public OrderException(String message) {
		
		this.message = message;
	}

	@Override
	public String getMessage() {
		return this.message;
	}

}
