package com.springcore.lifecycle;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {

		@SuppressWarnings("resource")
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("com/springcore/lifecycle/config.xml");
		context.registerShutdownHook();

		Samosa s1 = (Samosa) context.getBean("samosa1");
		System.out.println(s1);

		Pepsi p1 = (Pepsi) context.getBean("pepsi1");
		System.out.println(p1);

	}
}
