package com.souramandala.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.souramandala.entity.ResponseError;

@ControllerAdvice
public class GlobalException {
	@ExceptionHandler(value = CustomerException.class)
	public ResponseEntity<ResponseError>customerErrorThrowing(CustomerException customerException,
			HttpServletRequest httpServletRequest) {
		ResponseError error = new ResponseError(customerException.getMessage(), httpServletRequest.getRequestURI());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = OrderException.class)
	public ResponseEntity<ResponseError> orderErrorThrowing(OrderException orderException,
			HttpServletRequest httpServletRequest) {
		ResponseError error = new ResponseError(orderException.getMessage(), httpServletRequest.getRequestURI());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

}
