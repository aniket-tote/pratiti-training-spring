package com.pratiti.modal;

public class Passenger {

	private String name;
	private Gender gender;
	private Status status;
	private int age;
	
	
	public static enum Gender{
		MALE, FEMALE,OTHER;
	}
	public static enum Status{
		WAITING,RAC,CONFIRMED;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	
}
