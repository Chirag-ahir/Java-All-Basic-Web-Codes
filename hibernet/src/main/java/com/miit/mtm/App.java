package com.miit.mtm;

import org.hibernate.cfg.Configuration;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class App {
	public static void main(String[] args) {

		Configuration config = new Configuration().configure();
		config.addAnnotatedClass(com.miit.mtm.Emp.class).addAnnotatedClass(com.miit.mtm.Project.class);
		StandardServiceRegistryBuilder build = new StandardServiceRegistryBuilder().applySettings(config.getProperties());
		SessionFactory factory = config.buildSessionFactory(build.build());

		Emp e1 = new Emp();
		Emp e2 = new Emp();
		e1.setEid(34);
		e1.setName("Ram");
		e2.setEid(35);
		e2.setName("Shyam");

		Project p1 = new Project();
		Project p2 = new Project();
		p1.setPid(12121);
		p1.setProjectName("Omegle");
		p2.setPid(14124);
		p2.setProjectName("Agile");

		List<Emp> list1 = new ArrayList<Emp>();
		List<Project> list2 = new ArrayList<Project>();

		list1.add(e1);
		list1.add(e2);

		list2.add(p1);
		list2.add(p2);

		e1.setProjects(list2);
		e2.setProjects(list2);
		p1.setEmployees(list1);

		Session s = factory.openSession();
		Transaction tx = s.beginTransaction();

		s.save(e1);
		s.save(e2);
		s.save(p1);
		s.save(p2);

		tx.commit();
		s.close();
		factory.close();

	}

}
