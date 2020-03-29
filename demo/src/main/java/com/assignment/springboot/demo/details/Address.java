package com.assignment.springboot.demo.details;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Address {

	@Value("${address.street}")
	private String street;
	
	@Value("${address.city}")
	private String city;
	
	@Value("${address.zip}")
	private String zip;
	
	public Address() {
		
	}

	public String getStreet() {
		return street;
	}

	public String getCity() {
		return city;
	}
	
	public String getZip() {
		return zip;
	}
	
	public String getAddress() {
		return "Street: "+getStreet()+", City: "+getCity()+", Zip-Code: "+getZip()+".";
	}
	
}
