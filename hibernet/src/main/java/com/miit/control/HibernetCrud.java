package com.miit.control;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.miit.dao.Player;

public class HibernetCrud {
	public static void main(String[] args) {

		try {
			Configuration config = new Configuration().configure();
			config.addAnnotatedClass(com.miit.dao.Player.class);

			StandardServiceRegistryBuilder build = new StandardServiceRegistryBuilder()
					.applySettings(config.getProperties());
			SessionFactory factory = config.buildSessionFactory(build.build());

			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();

			// ============CREATE============
			Player p1 = new Player("Virat", "India", 30);
			Player p2 = new Player("Harshil", "India", 32);

			session.save(p1);
			session.save(p2);

			// ============READ===========
			Player p = session.get(Player.class, 1);
			System.out.println("The details are: " + p);

			// ========UPDATE==========
			// p.setPlayerName("Sanket");
			// p.setAge(23);

			// =========DELETE==========
			// session.delete(p);

			transaction.commit();
			session.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
