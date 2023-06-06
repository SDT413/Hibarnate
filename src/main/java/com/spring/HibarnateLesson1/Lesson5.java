package com.spring.HibarnateLesson1;

import com.spring.HibarnateLesson1.hibernate_test.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Lesson5 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml").
                addAnnotatedClass(Children.class).
                addAnnotatedClass(Section.class).
                buildSessionFactory();
        Children child = new Children("Zaur",  7);
        Children child1 = new Children("Vasya",  8);
        Children child2 = new Children("Nikolya",  6);
        Children child3 = new Children("Masha",  4);
        Children child4 = new Children("Petya",  2);
        Children child5 = new Children("Igor",  1);
        Section section = new Section("Math");
        section.addChildToSection(child);
        section.addChildToSection(child1);
        section.addChildToSection(child2);
        section.addChildToSection(child3);
        section.addChildToSection(child4);
        section.addChildToSection(child5);
        Session session = factory.getCurrentSession();
        try {
            session.beginTransaction();
            session.persist(section);
            session.getTransaction().commit();
        }
        finally {
            session.close();
            factory.close();
        }
    }
}
