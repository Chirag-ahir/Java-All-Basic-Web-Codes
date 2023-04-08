package com.miit.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.miit.user.User;

public class UserDao {

	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public int addUser(User u) {
		Session session = hibernateTemplate.getSessionFactory().openSession();
		session.beginTransaction();

		int id = (int) session.save(u);
		session.getTransaction().commit();
		return id;
	}

	public List<User> getAllUsers() {
		List<User> userList = new ArrayList<User>();
		userList = hibernateTemplate.loadAll(User.class);
		return userList;
	}
}
