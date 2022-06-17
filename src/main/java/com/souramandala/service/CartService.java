package com.souramandala.service;

import com.souramandala.entity.Cart;
import com.souramandala.exception.CustomerException;

public interface CartService {
	
	public abstract Cart createCart(Cart cart) throws CustomerException;
	
	public abstract int getTheCartId(int CustId) throws CustomerException;
	
	public abstract Cart getCustomerCart(int cartId)throws CustomerException;

}
