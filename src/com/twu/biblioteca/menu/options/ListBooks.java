package com.twu.biblioteca.menu.options;

import com.twu.biblioteca.menu.Menu;
import com.twu.biblioteca.service.BookService;

public class ListBooks extends Menu {

    public ListBooks() {
        super("1. List books");
    }

    @Override
    public void executeOption() {
        showTableHeaders();
        new BookService().listAvailableBooks();
    }

    private void showTableHeaders() {
        System.out.println("______________________________________________________________________________________________");
        System.out.println(String.format("|%50s|%20s|%20s|", "Book title", "Author", "Year of publication"));
        System.out.println("|============================================================================================|");
    }
}
