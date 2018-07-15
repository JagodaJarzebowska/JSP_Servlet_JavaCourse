package com.sda.twitter.servlets;

import com.sda.twitter.model.User;
import com.sda.twitter.repository.UserDb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "RegisterServlet", value = "/register")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nick = req.getParameter("nick");
        String email = req.getParameter("email");
        String password = req.getParameter("pass");

        User user = new User();
        user.setEmail(email);
        user.setNick(nick);
        user.setPassword(password);

        UserDb userDb = UserDb.getInstance();
        userDb.getUserList().add(user);
        resp.sendRedirect("/");

    }
}
