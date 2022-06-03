package com.souramandala.service;

import java.util.List;


import com.souramandala.entity.OrderEntity;
import com.souramandala.entity.Product;
import com.souramandala.exception.OrderException;

public interface OrderService {
	
	public abstract String createOrder(OrderEntity orderEntity) throws OrderException;
	
	
	public abstract List<OrderEntity> getAllOrdersOfCust(int custId) throws OrderException;
	
	//public abstract List<Product> getAllProductsOfCust(int custId) throws OrderException;

}
