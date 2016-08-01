package com.twu.biblioteca.factory;

import com.twu.biblioteca.model.Menu;
import com.twu.biblioteca.model.options.*;

import java.util.HashMap;
import java.util.Map;

public class MenuFactory {

    private static final Map<Integer, Menu> menuOptions = new HashMap<Integer, Menu>();
    private static final InvalidOption INVALID_OPTION = new InvalidOption();

    public MenuFactory() {
        menuOptions.put(1, new ListBooks());
        menuOptions.put(2, new CheckoutBook());
        menuOptions.put(3, new ReturnBook());
        menuOptions.put(0, new Quit());
    }

    public static Map<Integer, Menu> getMenuOptions() {
        return menuOptions;
    }

    public Menu getMenuOption(int option) {
        Menu menu = menuOptions.get(option);
        if (menu == null) {
            menu = INVALID_OPTION;
        }
        return menu;
    }
}
