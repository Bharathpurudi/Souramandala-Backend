package com.souramandala.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.springframework.lang.Nullable;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cartId;
	@OneToOne
	@JoinColumn(name = "cust_id")
	@JsonBackReference
	private Customer customer;
	@JsonManagedReference
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "cart", cascade = CascadeType.ALL)
	private OrderEntity orderEntity;

	public Cart(int cartId, Customer customer) {
		super();
		this.cartId = cartId;
		this.customer = customer;
	}

	public Cart() {
		super();
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}


	public OrderEntity getOrderEntity() {
		return orderEntity;
	}

	/*
	 * public void setOrderEntity(OrderEntity orderEntity) { this.orderEntity =
	 * orderEntity; }
	 */

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	/*
	 * public void setCustId(int custId) { this.customer.setCustId(custId); }
	 */

}
