package com.twu.biblioteca.service;

import com.twu.biblioteca.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    private List<User> users;

    public UserService() {
        populateUsers();
    }

    private void populateUsers() {
        users = new ArrayList<User>();
        users.add(new User("Xavier", "xxx-xxxx", "12345"));
    }

    public User login(String libraryNumber, String password) {
        for (User user : users) {
            if (user.getLibraryNumber().equals(libraryNumber)) {
                if (user.getPassword().equals(password)) {
                    return user;
                }
            }
        }
        return null;
    }
}
