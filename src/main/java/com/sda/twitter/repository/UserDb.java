package com.sda.twitter.repository;

import com.sda.twitter.model.User;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public final class UserDb {

    private static volatile UserDb userDb;

    @Getter
    List<User> userList;

    private UserDb() {
        userList = new ArrayList<>();
    }

    public static synchronized UserDb getInstance() {
        if (userDb == null) {
            userDb = new UserDb();
        }
        return userDb;
    }
}
