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
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "order_entity")
public class OrderEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name = "cust_id")
	@JsonBackReference
	private Customer customer;
	@Column(nullable = false)
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
	@JsonManagedReference
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "order",cascade = CascadeType.ALL)
	private List<Product> products;

	public OrderEntity() {
		super();
	}

	public OrderEntity(int orderId, int invoiceNum, int orderAmount, int orderDiscount, int checkoutAmount,
			LocalDate orderDate, List<Product> products) {
		super();
		this.orderId = orderId;
		this.invoiceNum = invoiceNum;
		this.orderAmount = orderAmount;
		this.orderDiscount = orderDiscount;
		this.checkoutAmount = checkoutAmount;
		this.orderDate = orderDate;
		this.setProducts(products);
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

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

}
