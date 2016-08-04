package com.twu.biblioteca.menu;

import com.twu.biblioteca.model.User;
import com.twu.biblioteca.service.UserService;
import com.twu.biblioteca.util.UserInput;

public abstract class Menu {

    private String name;

    public Menu(String name) {
        this.name = name;
    }

    public abstract void executeOption();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    protected User showLogin() {
        String libraryNumber = UserInput.obtainInput("Write your library number: ");
        String password = UserInput.obtainInput("Write your password: ");
        UserService userService = new UserService();
        return userService.login(libraryNumber, password);
    }
}
