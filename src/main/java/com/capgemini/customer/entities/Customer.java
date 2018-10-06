package com.capgemini.customer.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customers")
public class Customer {
	
	@Id
	private int customerId;
	private String customerName;
	private String customerAddress;
	private String customerEmail;
	private String customerPassword;
	
	
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Customer(int customerId, String customerName, String customerAddress, String customerEmail,
			String password) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerAddress = customerAddress;
		this.customerEmail = customerEmail;
		this.customerPassword = customerPassword;
	}



	public int getCustomerId() {
		return customerId;
	}



	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}



	public String getCustomerName() {
		return customerName;
	}



	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}



	public String getCustomerAddress() {
		return customerAddress;
	}



	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}



	public String getCustomerEmail() {
		return customerEmail;
	}



	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}



	public String getCustomerPassword() {
		return customerPassword;
	}



	public void setPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}
	
	

	
}
