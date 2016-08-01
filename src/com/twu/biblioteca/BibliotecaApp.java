package com.twu.biblioteca;

import com.twu.biblioteca.service.MenuService;

import java.io.File;

public class BibliotecaApp {

    public static final String CHECKOUT_MESSAGE = "Thank you! Enjoy the book";
    public static final String UNSUCCESSFUL_CHECKOUT_MESSAGE = "That book is not available.";
    public static final String RETURN_MESSAGE = "Thank you for returning the book.";
    public static final String UNSUCCESSFUL_RETURN_MESSAGE = "That is not a valid book to return.";

    private static final String PATH = System.getProperty("user.dir") + File.separator +
            "resources" + File.separator;

    public static final String MENU_FILE = PATH + "menu.txt";

    public static void main(String[] args) {
        MenuService menuService = new MenuService();
        System.out.println(menuService.displayWelcomeMessage());
        System.out.println();
        menuService.displayMenuUntilQuit();
    }
}
