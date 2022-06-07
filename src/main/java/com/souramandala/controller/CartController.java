package com.souramandala.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.souramandala.entity.Cart;
import com.souramandala.service.CartService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/api")
public class CartController {
	
	@Autowired
	private CartService cartService;
	

	@PostMapping(value = "/cart", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String createCart(@RequestBody Cart cart) {
		return cartService.createCart(cart);
	}
	
	@GetMapping(value="/cart/getcartid/{custId}")
	public int getCartId(@PathVariable int custId) {
		return cartService.getTheCartId(custId);
	}

}
