package com.souramandala.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productId;
	@Column(nullable = false)
	private String productName;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "order_id")
	@JsonBackReference
	private OrderEntity order;
	private int productPrice;
	@JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
	private LocalDate productDom;
	@JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
	private LocalDate productDoe;
	@JsonManagedReference
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "product",cascade = CascadeType.ALL)
	private Warranty warrantyDetails;

	public Product() {
		super();
	}

	public Product(int productId, String productName, int productPrice, LocalDate productDom, LocalDate productDoe,
			Warranty warrantyDetails) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productDom = productDom;
		this.productDoe = productDoe;
		this.warrantyDetails = warrantyDetails;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public LocalDate getProductDom() {
		return productDom;
	}

	public void setProductDom(LocalDate productDom) {
		this.productDom = productDom;
	}

	public LocalDate getProductDoe() {
		return productDoe;
	}

	public void setProductDoe(LocalDate productDoe) {
		this.productDoe = productDoe;
	}

	public Warranty getWarrantyDetails() {
		return warrantyDetails;
	}

	public void setWarrantyDetails(Warranty warrantyDetails) {
		this.warrantyDetails = warrantyDetails;
	}

}
