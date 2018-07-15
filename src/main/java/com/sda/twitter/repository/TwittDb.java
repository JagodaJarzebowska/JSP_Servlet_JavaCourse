package com.sda.twitter.repository;

import com.sda.twitter.model.Twitt;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public final class TwittDb {

    private static volatile TwittDb twittDb;
    @Getter
    private List<Twitt> twittList;

    private TwittDb() {
        twittList = new ArrayList<>();
    }

    public static synchronized TwittDb getInstance() {
        if (twittDb == null) {
            twittDb = new TwittDb();
        }
        return twittDb;
    }
}
