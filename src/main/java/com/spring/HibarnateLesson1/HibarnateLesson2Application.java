package com.spring.HibarnateLesson1;

import com.spring.HibarnateLesson1.hibernate_test.entity.Details;
import com.spring.HibarnateLesson1.hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
public class HibarnateLesson2Application {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml").
                addAnnotatedClass(Employee.class).
                addAnnotatedClass(Details.class).
                buildSessionFactory();

        Employee employee = new Employee("Oleg", "Ivanov",  1000);
        Details details = new Details("Moscow", "123456789", ".com");
        employee.setDetails(details);
        Session session = factory.getCurrentSession();
        try {
            session.beginTransaction();
            session.save(employee);
            session.getTransaction().commit();
        }

        finally {
            session.close();
            factory.close();
        }
    }

}
