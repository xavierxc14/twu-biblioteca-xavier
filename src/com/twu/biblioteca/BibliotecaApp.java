package com.twu.biblioteca;

import com.twu.biblioteca.service.BookService;
import com.twu.biblioteca.service.MenuService;

import java.io.File;

public class BibliotecaApp {

    private static final String PATH = System.getProperty("user.dir") + File.separator +
            "resources" + File.separator;

    public static final String MENU_FILE = PATH + "menu.txt";

    public static void main(String[] args) {
        BookService.getInstance().populateBooks();
        MenuService menuService = new MenuService();
        System.out.println(menuService.displayWelcomeMessage());
        System.out.println();
        menuService.displayMenuUntilQuit();
    }
}
