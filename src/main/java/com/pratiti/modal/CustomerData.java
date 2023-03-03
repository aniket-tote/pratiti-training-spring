package com.pratiti.modal;

import java.time.LocalDate;

import javax.persistence.Lob;

import org.springframework.web.multipart.MultipartFile;

import com.pratiti.entity.Address;

public class CustomerData {
	private String name;
	private String dateOfBirth;
	private String email;
	private String password;

	private Address address = new Address();
	
	private MultipartFile profilePic;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public MultipartFile getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(MultipartFile profilePic) {
		this.profilePic = profilePic;
	}

	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
