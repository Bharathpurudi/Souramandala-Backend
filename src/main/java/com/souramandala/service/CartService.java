package com.souramandala.service;

import com.souramandala.entity.Cart;
import com.souramandala.exception.CustomerException;

public interface CartService {
	
	public abstract String createCart(Cart cart) throws CustomerException;
	
	public abstract int getTheCartId(int CustId) throws CustomerException;

}
