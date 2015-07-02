package com.cegeka.spacebook;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String username;
    private List<Person> friends;

    public Person(String username) {
        if(StringUtils.isBlank(username)) {
            throw new IllegalArgumentException();
        }

        this.username = username;
        this.friends = new ArrayList<Person>();
    }

    public String getUsername() {
        return username;
    }

    public List<Person> getFriends() {
        return friends;
    }
}
