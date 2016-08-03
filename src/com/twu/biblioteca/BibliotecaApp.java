package com.twu.biblioteca;

import com.twu.biblioteca.service.BookService;
import com.twu.biblioteca.service.MenuService;
import com.twu.biblioteca.service.MovieService;

public class BibliotecaApp {

    public static void main(String[] args) {
        BookService.populateBooks();
        MenuService menuService = new MenuService();
        MovieService.populateMovies();
        System.out.println(menuService.displayWelcomeMessage());
        System.out.println();
        int option = Integer.MAX_VALUE;
        while (option != 0) {
            option = menuService.displayMenu();
        }
    }
}
