package com.assignment.springboot.demo.details;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Student {

	@Value("${student.firstName}")
	private String firstName;
	
	@Value("${student.lastName}")
	private String lastName;
	
	@Autowired
	private Address address;
	
	public Student() {
		
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}

	public Address getAddress() {
		return address;
	}
	
	public String studentDetails() {
		return "Name: "+getFirstName()+" "+getLastName()+", "+address.getAddress();
	}
	
}
