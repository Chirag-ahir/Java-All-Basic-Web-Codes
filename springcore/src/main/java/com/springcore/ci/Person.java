package com.springcore.ci;

public class Person {

	private String name;
	private int personId;
	private Certificate certi;

	public Person(String name, int personId, Certificate certi) {
		super();
		this.name = name;
		this.personId = personId;
		this.certi = certi;
	}

	@Override
	public String toString() {
		return "Person [name = " + this.name + ", personId = " + this.personId + ", certi = " + this.certi + "]";
	}
	
}
