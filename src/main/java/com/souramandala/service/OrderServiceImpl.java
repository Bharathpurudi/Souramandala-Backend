package com.souramandala.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.souramandala.entity.OrderEntity;
import com.souramandala.exception.OrderException;
import com.souramandala.repo.OrderRepo;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderRepo orderRepo;
	
	@Override
	public String createOrder(OrderEntity orderEntity) throws OrderException {
		OrderEntity entity= orderRepo.save(orderEntity);
		if(entity!=null) {
			return "Order created successfully";
		}else {
			throw new OrderException("Issue raised while creating the order");
		}
		
	}
	
	@Override
	public List<OrderEntity> getAllOrdersOfCust(int custId){
		List<OrderEntity> orders = orderRepo.findAllOrdsCustomer(custId);
		if(orders != null) {
			return orders;
		}else {
			throw new OrderException("No orders for the given cust id");
		}
	}

	

}
