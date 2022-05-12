package com.souramandala.entity;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
@Table(name = "order_entity")
public class OrderEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="cust_id",nullable = false, referencedColumnName = "custId")
	@JsonBackReference
	private Customer customer;
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
	//@JsonManagedReference
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "order_product",
    joinColumns = {
            @JoinColumn(name = "order_id", referencedColumnName = "orderId",
                    nullable = false, updatable = false)},
    inverseJoinColumns = {
            @JoinColumn(name = "product_id", referencedColumnName = "productId",
                    nullable = false, updatable = false)})
	private Set<Product> products;
	

	public OrderEntity() {
		super();
	}

	public OrderEntity(int orderId, int invoiceNum, int orderAmount, int orderDiscount, int checkoutAmount,
			LocalDate orderDate, Set<Product> products) {
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

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

}
