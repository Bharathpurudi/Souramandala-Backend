package com.souramandala.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Warranty {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int warrantyId;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id")
	@JsonBackReference
	private Product product;
	@Column(nullable = false)
	private int warrantyMonths;
	@Column(nullable = false)
	private String warrantyType;

	public Warranty() {
		super();
	}

	public Warranty(int warrantyId, int warrantyMonths, String warrantyType) {
		super();
		this.warrantyId = warrantyId;

		this.warrantyMonths = warrantyMonths;
		this.warrantyType = warrantyType;
	}

	public int getWarrantyId() {
		return warrantyId;
	}

	public void setWarrantyId(int warrantyId) {
		this.warrantyId = warrantyId;
	}

	public int getWarrantyMonths() {
		return warrantyMonths;
	}

	public void setWarrantyMonths(int warrantyMonths) {
		this.warrantyMonths = warrantyMonths;
	}

	public String getWarrantyType() {
		return warrantyType;
	}

	public void setWarrantyType(String warrantyType) {
		this.warrantyType = warrantyType;
	}

}
