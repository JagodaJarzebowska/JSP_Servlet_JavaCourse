package com.sda.twitter.servlets;

import com.sda.twitter.model.Twitt;
import com.sda.twitter.model.User;
import com.sda.twitter.repository.TwittDb;
import com.sda.twitter.utils.Utils;
import jdk.nashorn.internal.ir.Optimistic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "TwittServlet", value = "/message")
public class TwittServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String message = req.getParameter("message");

        Utils.getUserFromCookies(req)
                .ifPresent(user -> {
                    Twitt twitt = new Twitt();
                    twitt.setUser(user);
                    twitt.setMessage(message);
                    twitt.setDate(System.currentTimeMillis());

                    TwittDb twittDb = TwittDb.getInstance();
                    twittDb.getTwittList().add(twitt);
                });
             resp.sendRedirect("/");


//        Twitt twitt = new Twitt();                przenosimy do lambdy
//        twitt.setMessage(message);
//        twitt.setDate(System.currentTimeMillis());
//
//        TwittDb twittDb = TwittDb.getInstance();
//        twittDb.getTwittList().add(twitt);
//        resp.sendRedirect("/");

    }
}
