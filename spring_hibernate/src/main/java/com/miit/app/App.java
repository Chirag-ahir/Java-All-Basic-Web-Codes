package com.miit.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.miit.dao.UserDao;

public class App {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		ApplicationContext ap = new ClassPathXmlApplicationContext("beans.xml");
		UserDao dao = (UserDao)ap.getBean("dao");
	
		//User u1 = new User("Ppatel97",89,123456789);
		//System.out.println(dao.addUser(u1));
		
		System.out.println("List of all Users are :: ");
		System.out.println(dao.getAllUsers());
		
	}
}
