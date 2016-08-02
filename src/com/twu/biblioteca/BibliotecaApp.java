package com.twu.biblioteca;

import com.twu.biblioteca.service.MenuService;

public class BibliotecaApp {

    public static void main(String[] args) {
        MenuService menuService = new MenuService();
        System.out.println(menuService.displayWelcomeMessage());
        System.out.println();
        int option = Integer.MAX_VALUE;
        while (option != 0) {
            option = menuService.displayMenu();
        }
    }
}
