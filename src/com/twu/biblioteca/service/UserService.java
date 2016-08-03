package com.twu.biblioteca.service;

import com.twu.biblioteca.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserService {

    private static UserService instance;

    private List<User> users;

    private User loggedIn;

    private UserService() {
        populateUsers();
    }

    public static UserService getInstance() {
        if (instance == null) {
            instance = new UserService();
        }
        return instance;
    }

    private void populateUsers() {
        users = new ArrayList<User>();
        users.add(new User("Xavier", "6543-1234", "12345", "xnaunay@thoughtworks.com", "0987654321"));
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
