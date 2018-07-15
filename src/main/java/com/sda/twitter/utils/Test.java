package com.sda.twitter.utils;

import org.hibernate.Session;

public class Test {

    public static void main(String[] args) {
        HibernateUtils.openSession();
        System.out.println("test");
        HibernateUtils.closeSession();
    }
}
