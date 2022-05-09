package com.souramandala.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.souramandala.entity.Customer;
import com.souramandala.entity.OrderEntity;
import com.souramandala.exception.OrderException;
import com.souramandala.service.OrderServiceImpl;

@RestController
@RequestMapping(value="/souramandala/order")
public class OrderController {
	@Autowired
	private OrderServiceImpl orderServiceImpl;
	
	@PostMapping(value="/createorder", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String createOrder(@RequestBody OrderEntity orderEntity) {
		return orderServiceImpl.createOrder(orderEntity);
	}
	
	@GetMapping(value="/getordersofcust/{custId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<OrderEntity> getOrdersOfCust(@PathVariable int custId){
		return orderServiceImpl.getAllOrdersOfCust(custId);
	}
	
	@ExceptionHandler(value = com.souramandala.exception.OrderException.class)
	public String exceptionThrowerOrder(OrderException orderException) {
		return orderException.getMessage();
	}

}
