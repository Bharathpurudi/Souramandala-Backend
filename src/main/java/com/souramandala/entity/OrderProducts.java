package com.souramandala.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class OrderProducts {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int orderProductsId;
	private int productId;
	private int quantity;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "order_id", nullable = false, referencedColumnName = "orderId")
	@JsonBackReference
	private OrderEntity orderEntity;

	public OrderProducts() {
		super();
	};

	public OrderProducts(int orderProductsId, int productId, int quantity) {
		super();
		this.orderProductsId = orderProductsId;
		this.productId = productId;
		this.quantity = quantity;
	}

	public int getOrderProductsId() {
		return orderProductsId;
	}

	public void setOrderProductsId(int orderProductsId) {
		this.orderProductsId = orderProductsId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
