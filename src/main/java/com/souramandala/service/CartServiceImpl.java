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
		cartRepo.saveAndFlush(cart);
		return "Cart Added Successfully";
	}

	@Override
	public int getTheCartId(int CustId) throws CustomerException {
		Cart temp= cartRepo.findCartIdByCustId(CustId);
		int ret=0;
		if(temp!=null) {
			ret=temp.getCartId();
		}else {
			ret=0;
		}
		return ret;
		
		
	}

	@Override
	public Cart getCustomerCart(int cartId) throws CustomerException {
		return this.cartRepo.findBycartId(cartId);
	}

}
