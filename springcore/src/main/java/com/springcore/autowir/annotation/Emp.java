package com.springcore.autowir.annotation;

import org.springframework.beans.factory.annotation.Autowired;

public class Emp {

	@Autowired
	private Address address;

	public Emp() {
		super();
	}

	public Emp(Address address) {
		super();
		this.address = address;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String toString() {
		return "Emp [address = " + address + "]";
	}

}
