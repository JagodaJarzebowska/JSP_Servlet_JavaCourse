package com.sda.twitter.utils;

import com.sda.twitter.dao.UserDAO;
import com.sda.twitter.model.User;

public class Test {

    public static void main(String[] args) {
        HibernateUtils.openSession();
        User user = new User();
        user.setNick("nicka");
        user.setPassword("123a");
        user.setEmail("ja@jaa.pl");

        UserDAO userDAO = new UserDAO();
        userDAO.save(user);
        HibernateUtils.closeSession();
    }
}
