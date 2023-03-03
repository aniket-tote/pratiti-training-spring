package com.pratiti.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pratiti.entity.Customer;
import com.pratiti.entity.Customer.Status;
import com.pratiti.exception.CustomerServiceException;
import com.pratiti.modal.LoginData;
import com.pratiti.repository.AddressRepository;
import com.pratiti.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
//	@Autowired
//	private AddressRepository addressRepository;
	
	public int register(Customer customer) {
		if(customerRepository.existsByEmail(customer.getEmail())){
			throw new CustomerServiceException("Customer already registered");
		}
		customer.setStatus(Status.INACTIVE);
		customer.getAddress().setCustomer(customer);
		customerRepository.save(customer);
		return customer.getId();	
	}
	
	public void activate(int id) {
		Optional<Customer> customer = customerRepository.findById(id);
		if(customer.isEmpty()){
			throw new CustomerServiceException("Customer Not found");
		}
		Customer customerData = customer.get();
		if(customerData.getStatus() == Status.LOCKED) {
			throw new CustomerServiceException("Account is locked!! Contact Admin.");
		}else if(customerData.getStatus() == Status.ACTIVE){
			throw new CustomerServiceException("Account is Already Active.");
		}
		customerData.setStatus(Status.ACTIVE);
		customerRepository.save(customerData);
	}
	
	public Customer login(LoginData loginData) {
		Optional<Customer> customer = customerRepository.findByEmailAndPassword(loginData.getEmail(),loginData.getPassword());
		if(customer.isEmpty()){
			throw new CustomerServiceException("Customer Not found");
		}
		Customer customerData = customer.get();
		if(customerData.getStatus() == Status.LOCKED) {
			throw new CustomerServiceException("Account is locked!! Contact Admin.");
		}else if(customerData.getStatus() == Status.INACTIVE){
			throw new CustomerServiceException("Account is Inactive!! Please activate it first.");
		}
		return customerData;
	}
	
	
}
