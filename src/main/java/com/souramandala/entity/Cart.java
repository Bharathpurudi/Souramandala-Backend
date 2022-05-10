package com.souramandala.entity;

import java.time.LocalDate;
import java.util.List;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
@Entity
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cartId;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cust_id", referencedColumnName = "custId")
	@JsonBackReference
	private Customer customer;
	@JsonManagedReference
	@OneToMany(mappedBy = "cart", fetch = FetchType.LAZY)
	private List<OrderEntity> orders;
	private int deliveryCharge;
	private int orderAmount;
	private int totalDiscountApplied;
	private int checkoutAmount;
	@JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
	private LocalDate dateOfDelivery;
	
	public Cart() {
		super();
	}

	public Cart(int cartId, List<OrderEntity> orders,int deliveryCharge , int orderAmount, int totalDiscountApplied,
			int checkoutAmount, LocalDate dateOfDelivery) {
		super();
		this.cartId = cartId;
		this.orders = orders;
		this.orderAmount = orderAmount;
		this.totalDiscountApplied = totalDiscountApplied;
		this.checkoutAmount = checkoutAmount;
		this.dateOfDelivery = dateOfDelivery;
		this.deliveryCharge=deliveryCharge;
	}



	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public int getDeliveryCharge() {
		return deliveryCharge;
	}

	
	public void setDeliveryCharge(int deliveryCharge) {
		this.deliveryCharge = deliveryCharge;
	}

	public int getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(int orderAmount) {
		this.orderAmount = orderAmount;
	}

	public int getTotalDiscountApplied() {
		return totalDiscountApplied;
	}

	public void setTotalDiscountApplied(int totalDiscountApplied) {
		this.totalDiscountApplied = totalDiscountApplied;
	}

	public int getCheckoutAmount() {
		return checkoutAmount;
	}

	public void setCheckoutAmount(int checkoutAmount) {
		this.checkoutAmount = checkoutAmount;
	}

	public LocalDate getDateOfDelivery() {
		return dateOfDelivery;
	}

	public void setDateOfDelivery(LocalDate dateOfDelivery) {
		this.dateOfDelivery = dateOfDelivery;
	}

	public List<OrderEntity> getOrders() {
		return orders;
	}

	public void setOrders(List<OrderEntity> orders) {
		this.orders = orders;
	}
	

	
	

}
