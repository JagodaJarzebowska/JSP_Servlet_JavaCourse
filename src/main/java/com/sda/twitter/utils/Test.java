package com.sda.twitter.utils;

import com.sda.twitter.dao.UserDAO;
import com.sda.twitter.model.User;

public class Test {

    public static void main(String[] args) {
        HibernateUtils.openSession();
        User user = new User();
        user.setNick("nicasfafka");
        user.setPassword("asda123a");
        user.setEmail("jaasda@jaa.pl");

        UserDAO userDAO = new UserDAO();
        userDAO.save(user);
        HibernateUtils.closeSession();
    }
}
