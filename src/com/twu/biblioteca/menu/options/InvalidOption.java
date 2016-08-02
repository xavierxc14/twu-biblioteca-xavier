package com.twu.biblioteca.menu.options;

import com.twu.biblioteca.menu.Menu;

public class InvalidOption extends Menu {

    private static final String INVALID_OPTION = "Select a valid option!";

    public InvalidOption() {
        super("");
    }

    @Override
    public void executeOption() {
        System.out.println(INVALID_OPTION);
    }
}
