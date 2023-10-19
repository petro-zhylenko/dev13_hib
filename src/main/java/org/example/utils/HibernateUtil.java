package org.example.utils;

import org.example.entities.Address;
import org.example.entities.Contact;
import org.example.entities.Person;
import org.example.entities.Work;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil implements AutoCloseable{
    private static final HibernateUtil INSTANCE;

    private SessionFactory sessionFactory;

    static {
        INSTANCE = new HibernateUtil();
    }

    private HibernateUtil() {
        sessionFactory = new Configuration()
                .addAnnotatedClass(Person.class)
                .addAnnotatedClass(Address.class)
                .addAnnotatedClass(Contact.class)
                .addAnnotatedClass(Work.class)
                .buildSessionFactory();
    }

    public static HibernateUtil getInstance() {
        return INSTANCE;
    }

    @Override
    public void close() {
        sessionFactory.close();
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
