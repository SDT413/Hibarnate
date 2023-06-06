package com.spring.HibarnateLesson1;

import com.spring.HibarnateLesson1.hibernate_test.entity.Department;
import com.spring.HibarnateLesson1.hibernate_test.entity.Details;
import com.spring.HibarnateLesson1.hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Lesson4 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml").
                addAnnotatedClass(Employee.class).
                addAnnotatedClass(Details.class).
                addAnnotatedClass(Department.class).
                buildSessionFactory();

        Employee employee = new Employee("Vasa", "Pupkin", 800);
        Department department = new Department("IT", 1000, 500);
        Session session = factory.getCurrentSession();
        try {
            session.beginTransaction();
            employee.setDepartment(department);
            session.save(employee);
            session.getTransaction().commit();
        }

        finally {
            session.close();
            factory.close();
        }
    }
}
