package com.souramandala.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;



@Entity
@Table(name = "order_entity")
public class OrderEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;
	@Column(nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int invoiceNum;
	@Column(nullable = false)
	private int orderAmount;
	@Column(nullable = false)
	private int orderDiscount;
	@Column(nullable = false)
	private int checkoutAmount;
	@JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
	@Column(nullable = false)
	private LocalDate orderDate;
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE, mappedBy = "orderEntity")
	private List<OrderProducts> orderProducts;
	@OneToOne
	@JoinColumn(name = "cart_id")
	@JsonBackReference
	private Cart cart;
	

	public OrderEntity() {
		super();
	}

	public OrderEntity(int orderId, int invoiceNum, int orderAmount, int orderDiscount, int checkoutAmount,
			LocalDate orderDate,List<OrderProducts> orderProducts ) {
		super();
		this.orderId = orderId;
		this.invoiceNum = invoiceNum;
		this.orderAmount = orderAmount;
		this.orderDiscount = orderDiscount;
		this.checkoutAmount = checkoutAmount;
		this.orderDate = orderDate;
		this.orderProducts=orderProducts;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getInvoiceNum() {
		return invoiceNum;
	}

	public void setInvoiceNum(int invoiceNum) {
		this.invoiceNum = invoiceNum;
	}

	public int getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(int orderAmount) {
		this.orderAmount = orderAmount;
	}

	public int getOrderDiscount() {
		return orderDiscount;
	}

	public void setOrderDiscount(int orderDiscount) {
		this.orderDiscount = orderDiscount;
	}

	public int getCheckoutAmount() {
		return checkoutAmount;
	}

	public void setCheckoutAmount(int checkoutAmount) {
		this.checkoutAmount = checkoutAmount;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public List<OrderProducts> getOrderProducts() {
		return orderProducts;
	}

	public void setOrderProducts(List<OrderProducts> orderProducts) {
		this.orderProducts = orderProducts;
	}

	

}
