package com.souramandala.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productId;
	@Column(nullable = false)
	private String productName;
	private int productPrice;
	@JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
	private LocalDate productDom;
	@JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
	private LocalDate productDoe;
	@Column(nullable = false)
	private int warrantyId;
	@Column(nullable = false)
	private String imageUrl;
	@Column(nullable = false)
	private boolean isExpired;
	@Column(nullable = false)
	private int stockQuantity;
	@Column(nullable = false)
	private String productCategory;

	public Product() {
		super();
	}

	public Product(int productId, String productName, int productPrice, LocalDate productDom, LocalDate productDoe,
			int warrantyId, String imageUrl, boolean isExpired, int stockQuantity, String productCategory) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productDom = productDom;
		this.productDoe = productDoe;
		this.warrantyId = warrantyId;
		this.imageUrl = imageUrl;
		this.isExpired = isExpired;
		this.stockQuantity = stockQuantity;
		this.productCategory = productCategory;
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

	public int getWarrantyId() {
		return warrantyId;
	}

	public void setWarrantyId(int warrantyId) {
		this.warrantyId = warrantyId;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public boolean isExpired() {
		return isExpired;
	}

	public void setExpired(boolean isExpired) {
		this.isExpired = isExpired;
	}

	public int getStockQuantity() {
		return stockQuantity;
	}

	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

}
