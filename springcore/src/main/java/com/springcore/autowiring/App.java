package com.springcore.autowiring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("com/springcore/autowiring/config.xml");
		Emp e1 = (Emp)context.getBean("emp");
		System.out.println(e1);
		
	}
}
