package com.miit.otm;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) {

		Configuration config = new Configuration().configure();
		config.addAnnotatedClass(com.miit.otm.Laptop.class).addAnnotatedClass(com.miit.otm.Student.class);
		StandardServiceRegistryBuilder build = new StandardServiceRegistryBuilder().applySettings(config.getProperties());
		SessionFactory factory = config.buildSessionFactory(build.build());

		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		Laptop l1 = new Laptop();
		Laptop l2 = new Laptop();
		l1.setLid(101);
		l1.setLname("HP");
		l2.setLid(102);
		l2.setLname("DELL");

		Student s1 = new Student();
		s1.setName("Parth");
		s1.setRollno(1);
		s1.setMarks(98);
		s1.getLaptop().add(l1);
		s1.getLaptop().add(l2);

		session.save(l1);
		session.save(l2);
		session.save(s1);
		
		transaction.commit();
		session.close();

	}

}
