package com.souramandala.service;

import com.souramandala.entity.Cart;

public interface CartService {
	
	public abstract Cart checkoutCart(int custId);

}
