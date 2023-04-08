package com.miit.mto;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) {

		Configuration config = new Configuration().configure();
		config.addAnnotatedClass(com.miit.mto.Question.class).addAnnotatedClass(com.miit.mto.Answer.class);
		StandardServiceRegistryBuilder build = new StandardServiceRegistryBuilder()
				.applySettings(config.getProperties());
		SessionFactory factory = config.buildSessionFactory(build.build());

		// creating question
		Question q1 = new Question();
		q1.setQuestionId(1212);
		q1.setQuestion("What is Java?");

		Answer ans1 = new Answer();
		ans1.setAnswerId(343);
		ans1.setAnswer("Java is object oriented programming language");
		ans1.setQuestion(q1);

		Answer ans2 = new Answer();
		ans2.setAnswerId(333);
		ans2.setAnswer("Java is server-side programming language");
		ans2.setQuestion(q1);

		Answer ans3 = new Answer();
		ans3.setAnswerId(363);
		ans3.setAnswer("Java has different types of framework");
		ans3.setQuestion(q1);

		List<Answer> list = new ArrayList<Answer>();
		list.add(ans1);
		list.add(ans2);
		list.add(ans3);

		q1.setAnswers(list);

		Session s = factory.openSession();
		Transaction tx = s.beginTransaction();

		s.save(q1);
		s.save(ans1);
		s.save(ans2);
		s.save(ans3);

		tx.commit();
		s.close();
	}
}
