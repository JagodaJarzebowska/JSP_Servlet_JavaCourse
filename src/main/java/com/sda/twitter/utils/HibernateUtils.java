package com.sda.twitter.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

    private final static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    private static Session session = null;

    public static  Session openSession(){
        if(session == null){
             session = sessionFactory.openSession();
        }
        return session;
    }

    public static void closeSession(){
        session.close();
        sessionFactory.close();
    }

}
