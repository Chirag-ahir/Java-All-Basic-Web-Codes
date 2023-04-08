package com.springcore.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

//Implementing bean lifecycle using interface
public class Pepsi implements InitializingBean, DisposableBean {

	private double price;

	public Pepsi() {
		super();
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void afterPropertiesSet() throws Exception {
		// init method
		System.out.println("Inside init: pepsi");
	}

	public void destroy() throws Exception {
		System.out.println("Inside destroy: pepsi");
	}

	@Override
	public String toString() {
		return "Pepsi [price=" + price + "]";
	}
}
