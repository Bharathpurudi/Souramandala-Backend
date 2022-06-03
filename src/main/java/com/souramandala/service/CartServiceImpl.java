package com.souramandala.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.souramandala.entity.Cart;
import com.souramandala.exception.CustomerException;
import com.souramandala.repo.CartRepo;
@Service
@Transactional
public class CartServiceImpl implements CartService {
	@Autowired
	private CartRepo cartRepo;
	
	@Override
	public String createCart(Cart cart) throws CustomerException {
		cartRepo.save(cart);
		return "Cart Added Successfully";
	}

}
