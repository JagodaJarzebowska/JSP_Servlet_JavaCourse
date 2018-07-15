package com.sda.twitter.utils;

import com.sda.twitter.model.User;
import com.sda.twitter.repository.UserDb;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Optional;

public final class Utils {

    public final static String USER_COOOKIE_NAME = "userCookie";

    private Utils(){

    }

    public static Optional<User> getUserFromCookies(final HttpServletRequest req){
       Optional<Cookie> first = Arrays.stream(req.getCookies())
                .filter(cookie -> USER_COOOKIE_NAME.equals(cookie.getName()))  // aby zapobiec NPE
//                .filter(cookie -> cookie.getName().equals(USER_COOOKIE_NAME)
                .findFirst();

       if (first.isPresent()){
           String nick = first.get().getValue();
           UserDb userDb = UserDb.getInstance();

           return userDb.getUserList().stream()
                   .filter(user ->nick.equals(user.getNick()))
                   .findFirst();
       }
        return Optional.empty();
    }
}
