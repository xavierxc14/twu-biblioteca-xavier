package com.twu.biblioteca.model.options;

import com.twu.biblioteca.model.Menu;
import com.twu.biblioteca.service.BookService;

public class ListBooks extends Menu {

    public ListBooks(String name) {
        super(name);
    }

    @Override
    public void executeOption() {
        showTableHeaders();
        BookService.getInstance().listAvailableBooks();
    }

    private void showTableHeaders() {
        System.out.println("_________________________________________________________________________________________");
        System.out.println(String.format("|%50s|%15s|%20s|", "Book title", "Author", "Year of publication"));
        System.out.println("|=======================================================================================|");
    }
}
