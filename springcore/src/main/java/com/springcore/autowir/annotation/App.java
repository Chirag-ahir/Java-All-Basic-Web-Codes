package com.springcore.autowir.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//This example demonstrate how we can use @Autowired annotation :: https://youtu.be/jPA6tz8YNiA
public class App {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("com/springcore/autowir/annotation/config.xml");
		Emp e1 = (Emp)context.getBean("emp");
		System.out.println(e1);
		
	}
}
