package com.springcore.lifecycle;

//Implementing bean lifecycle using xml file 
public class Samosa {

	private double price;

	public Samosa() {
		super();
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void init() {
		System.out.println("Inside init");
	}

	public void destroy() {
		System.out.println("Inside destroy");
	}

	@Override
	public String toString() {
		return "Samosa [price = " + price + "]";
	}

}
