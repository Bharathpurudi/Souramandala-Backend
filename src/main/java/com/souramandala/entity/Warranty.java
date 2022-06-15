package com.souramandala.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Warranty {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int warrantyId;
	@Column(nullable = false)
	private int warrantyMonths;
	@Column(nullable = false)
	private String warrantyType;

	public Warranty() {
		super();
	}

	public Warranty(int warrantyId, int warrantyMonths, String warrantyType) {
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
