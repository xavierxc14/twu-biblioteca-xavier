package com.twu.biblioteca.model.options;

import com.twu.biblioteca.model.Menu;

public class InvalidOption extends Menu {

    private static final String INVALID_OPTION = "Select a valid option!";

    public InvalidOption(String name) {
        super(name);
    }

    @Override
    public void executeOption() {
        System.out.println(INVALID_OPTION);
    }
}
