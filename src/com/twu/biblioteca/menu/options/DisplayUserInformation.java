package com.twu.biblioteca.menu.options;

import com.twu.biblioteca.menu.Menu;
import com.twu.biblioteca.service.UserService;

public class DisplayUserInformation extends Menu {

    public DisplayUserInformation() {
        super("6. Display user information");
    }

    @Override
    public void executeOption() {
        if (UserService.getLoggedIn() != null) {
            System.out.println(UserService.getLoggedIn().toString());
        } else {
            System.out.println("User not logged in, option not available!");
        }
    }
}
