package com.souramandala.service;

import java.time.LocalDate;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.souramandala.entity.Cart;
import com.souramandala.entity.OrderEntity;
import com.souramandala.exception.OrderException;
import com.souramandala.repo.CartRepo;
import com.souramandala.repo.OrderRepo;

@Service
public class CartServiceImpl implements CartService {
	@Autowired
	private CartRepo cartRepo;
	@Autowired
	private OrderRepo orderRepo;
	
	@Override
	public Cart checkoutCart(int custId) {
		List<OrderEntity> orders = orderRepo.findAllOrdsCustomer(custId);
		int checkOutAmount=0;
		int orderAmount=0;
		int discountAmount=0;
		int deliveryCharge=50;
		LocalDate orderDate=null;
		if(orders!=null) {
			for (OrderEntity orderEntity : orders) {
				orderAmount+=orderEntity.getOrderAmount();
				discountAmount+=orderEntity.getOrderDiscount();
				checkOutAmount+=orderEntity.getCheckoutAmount();
				orderDate=orderEntity.getOrderDate();
				
			}
		}else {
			throw new OrderException("No items in the cart. Do shopping and add products");
		}
		LocalDate deliveryDate= orderDate.plusDays(7);
		Cart cart= new Cart(custId, deliveryCharge, orderAmount, discountAmount, checkOutAmount+deliveryCharge, deliveryDate);
		return cartRepo.save(cart);
	}

}
