package com.miit.control;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.miit.dao.Player;


//with HQL we can write our custome query like SQL

public class HibernetHql {
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {

		try {
			Configuration config = new Configuration().configure();
			config.addAnnotatedClass(com.miit.dao.Player.class);
			StandardServiceRegistryBuilder build = new StandardServiceRegistryBuilder()
					.applySettings(config.getProperties());
			SessionFactory factory = config.buildSessionFactory(build.build());

			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();

			//Query query = session.createQuery("from Player");
			//Query query = session.createQuery("from Player order by age");
			Query query = session.createQuery("from Player where name='chirag'");
			
			
			List<Player> playerList = query.list();
			for (Player p : playerList) {
				System.out.println(p);
			}

			transaction.commit();
			session.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
