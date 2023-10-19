package org.example;

import org.example.entities.Address;
import org.example.entities.Contact;
import org.example.entities.Person;
import org.example.utils.HibernateUtil;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        try (HibernateUtil instance = HibernateUtil.getInstance();
             SessionFactory sessionFactory = instance.getSessionFactory();
             Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
//            Contact contact = new Contact();
//            contact.setEmail("test@gamil.com");
//            contact.setPhone("+380671231231");
//            Contact savedContact = session.merge(contact);
//            List<Person> resultList = session.createQuery("SELECT t from Person t right join t.address", Person.class)
//                    .getResultList();
//            resultList.stream().filter(Objects::nonNull)
//                    .forEach(p -> {
//                p.setContact(savedContact);
//                session.merge(p);
//            });
            List<Person> newResults = session.createQuery("SELECT t from Person t right join t.address", Person.class)
                    .getResultList();
            System.out.println(Arrays.toString(newResults.toArray()));
            transaction.commit();
        }
    }
}