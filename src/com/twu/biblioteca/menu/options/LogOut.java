package com.twu.biblioteca.menu.options;

import com.twu.biblioteca.menu.Menu;
import com.twu.biblioteca.service.UserService;

public class LogOut extends Menu {

    public LogOut() {
        super("7. Log Out");
    }

    @Override
    public void executeOption() {
        UserService.setLoggedIn(null);
        System.out.println("User logged out");
    }
}
