package org.example.unill;

import org.example.Entity.Admin;
import org.example.Entity.Books;
import org.example.Entity.Branch;
import org.example.Entity.Member;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.swing.text.Utilities;

public class SessionFactoryConfiguration {
    private static SessionFactoryConfiguration sessionFactoryConfiguration;
    private final SessionFactory sessionFactory;

    private SessionFactoryConfiguration(){
        sessionFactory = new Configuration()
                .mergeProperties(Utility.getProperties())
                .addAnnotatedClass(Member.class)
                .addAnnotatedClass(Admin.class)
                .addAnnotatedClass(Books.class)
                .addAnnotatedClass(Branch.class)
                .buildSessionFactory();
    }

    public static SessionFactoryConfiguration getInstance(){
        return (null == sessionFactoryConfiguration) ? sessionFactoryConfiguration = new SessionFactoryConfiguration()
                : sessionFactoryConfiguration;
    }

    public Session getSession(){
        return sessionFactory.openSession();
    }
}
