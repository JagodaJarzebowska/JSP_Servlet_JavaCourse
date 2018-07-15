package com.sda.twitter.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

    private final static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    private static Session session = sessionFactory.openSession();

    public static synchronized Session openSession(){
        if(session == null){
            synchronized (HibernateUtils.class){
                if(session == null) session = (Session) new HibernateUtils();
            }
        }
        return session;
    }

    public static void closeSession(){
        session.close();
        sessionFactory.close();
    }

}
