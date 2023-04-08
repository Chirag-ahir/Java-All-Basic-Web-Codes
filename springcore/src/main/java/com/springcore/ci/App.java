package com.springcore.ci;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


//this example demonstrate how constructor injection works in spring
public class App {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/springcore/ci/configci.xml");
		Person p1 = (Person) context.getBean("person1");
		System.out.println(p1);
	}
	
}
