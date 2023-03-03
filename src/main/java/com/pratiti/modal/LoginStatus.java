package com.pratiti.modal;

import com.pratiti.entity.Customer;

public class LoginStatus extends Status {
	private Customer customer;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
