package com.pratiti.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pratiti.entity.Customer;
import com.pratiti.exception.CustomerServiceException;
import com.pratiti.modal.ActivationStatus;
import com.pratiti.modal.CustomerData;
import com.pratiti.modal.LoginData;
import com.pratiti.modal.LoginStatus;
import com.pratiti.modal.RegistrationStatus;
import com.pratiti.service.CustomerService;


@RestController
@CrossOrigin
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
//	@PostMapping("/register")
//	public RegistrationStatus register(@RequestBody Customer customer) {
//		RegistrationStatus status = new RegistrationStatus();
//		try {
//			customerService.register(customer);
//			status.setStatus(true);
//			status.setMessageIfAny("Registered Successfully");
//			status.setRegisteredCustomerId(customer.getId());
//			
//		}catch(CustomerServiceException e) {
//			status.setStatus(false);
//			status.setMessageIfAny(e.getMessage());
//		}
//		return status;
//	}
	
	@PostMapping("/register")
	public RegistrationStatus register(CustomerData customerData) {
		
		RegistrationStatus status = new RegistrationStatus();
		try {
			String uploadDir = "C:\\Users\\anikettote\\eclipse-workspace\\spring-boot-demo\\public\\";
			InputStream f1 = customerData.getProfilePic().getInputStream();
			FileOutputStream f2 = new FileOutputStream(uploadDir+customerData.getProfilePic().getOriginalFilename());
			FileCopyUtils.copy(f1,f2);
			
			Customer customer = new Customer();

			customer.setDateOfBirth(LocalDate.of(Integer.parseInt(customerData.getDateOfBirth().substring(0, 4)),Integer.parseInt(customerData.getDateOfBirth().substring(5, 7)),Integer.parseInt(customerData.getDateOfBirth().substring(8, 10))));
			BeanUtils.copyProperties(customerData, customer);
			
			
			customer.setProfilePic(customerData.getProfilePic().getOriginalFilename());
			customerService.register(customer);
			status.setStatus(true);
			status.setMessageIfAny("Registered Successfully");
			status.setRegisteredCustomerId(customer.getId());
			
		}catch(IOException | CustomerServiceException e) {
			status.setStatus(false);
			status.setMessageIfAny(e.getMessage());
		}
		return status;
	}
	
	@GetMapping("/activate")
	public ActivationStatus activate(@RequestParam("id") int id) {
		ActivationStatus status = new ActivationStatus();
		try {
			customerService.activate(id);
			status.setStatus(true);
			status.setMessageIfAny("Activated");
		}catch(CustomerServiceException e) {
			status.setStatus(false);
			status.setMessageIfAny(e.getMessage());
		}
		
		return status;
	}
	
	@PostMapping("/login")
	public LoginStatus activate(@RequestBody LoginData loginData) {
		LoginStatus status = new LoginStatus();
		try {
			Customer customerData = customerService.login(loginData);
			status.setStatus(true);
			status.setMessageIfAny("Welcome back");
			status.setCustomer(customerData);
		}catch(CustomerServiceException e) {
			status.setStatus(false);
			status.setMessageIfAny(e.getMessage());
		}
		return status;
	}
	
}
