package com.spring.HibarnateLesson1;

import com.spring.HibarnateLesson1.hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class HibarnateLesson1Application {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml").
				addAnnotatedClass(Employee.class).
				buildSessionFactory();

		try {
			Session session = factory.getCurrentSession();
			session.beginTransaction();
			ArrayList<Employee> emps = (ArrayList<Employee>) session.createQuery("from Employee").getResultList();
			for (Employee emp : emps) {
				System.out.println(emp);
			}
			session.getTransaction().commit();
		}

		finally {
			factory.close();
		}
	}

}
