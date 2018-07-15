package com.sda.twitter.servlets;

import com.sda.twitter.model.User;
import com.sda.twitter.repository.UserDb;
import com.sda.twitter.utils.Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nick = req.getParameter("nick");
        String password = req.getParameter("pass");

        UserDb userDb = UserDb.getInstance();

        userDb.getUserList()
                .stream()
                .filter(user -> user.getNick().equals(nick) && user.getPassword().equals(password))
                .findFirst()
                .ifPresent(user -> resp.addCookie(new Cookie(Utils.USER_COOOKIE_NAME, user.getNick())));

        resp.sendRedirect("/");
    }
}
