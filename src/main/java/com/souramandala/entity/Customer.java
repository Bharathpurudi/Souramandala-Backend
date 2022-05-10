package com.souramandala.entity;

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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name = "customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int custId;
	@Column(nullable = false)
	private String userName;
	@Column(nullable = false, unique = true,columnDefinition="varchar(25) default 'Reset123'")
	private String password;
	@Column(nullable = false, unique = true)
	private String mobileNum;
	@Column(nullable = false, unique = true)
	private String mailId;
	//@JsonManagedReference
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "customer_order",
    joinColumns = {
            @JoinColumn(name = "cust_id", referencedColumnName = "custId",
                    nullable = false, updatable = false)},
    inverseJoinColumns = {
            @JoinColumn(name = "order_id", referencedColumnName = "orderId",
                    nullable = false, updatable = false)})
	private Set<OrderEntity> orders;
	@JsonManagedReference
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "customer", cascade = CascadeType.ALL)
	private Cart cart;

	public Customer() {
		super();
	}

	public Customer(int custId, String userName, String password, String mobileNum, String mailId, Set<OrderEntity> orders) {
		super();
		this.custId = custId;
		this.userName = userName;
		this.password = password;
		this.mobileNum = mobileNum;
		this.mailId = mailId;
		this.orders = orders;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobileNum() {
		return mobileNum;
	}

	public void setMobileNum(String mobileNum) {
		this.mobileNum = mobileNum;
	}

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	public Set<OrderEntity> getOrders() {
		return orders;
	}

	public void setOrders(Set<OrderEntity> orders) {
		this.orders = orders;
	}

}
