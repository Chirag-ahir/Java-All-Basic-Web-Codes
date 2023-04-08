package com.miit.oto;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

//This program demonstrate how one to one relationship works in hibernet
public class App {
	public static void main(String[] args) {
		
		Configuration config = new Configuration().configure();
		config.addAnnotatedClass(com.miit.oto.Employee.class).addAnnotatedClass(com.miit.oto.Account.class);
		StandardServiceRegistryBuilder build = new StandardServiceRegistryBuilder().applySettings(config.getProperties());
		SessionFactory factory = config.buildSessionFactory(build.build());
		
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		//Add new account
		Account account = new Account();
		account.setAccountNumber("2068102516985");
		session.save(account);
		
		//Add new employee
		Employee emp = new Employee();
		emp.setFirstName("Raj");
		emp.setLastName("Patel");
		emp.setAccount(account);
		session.save(emp);
		
		transaction.commit();
		session.close();
	}
}
