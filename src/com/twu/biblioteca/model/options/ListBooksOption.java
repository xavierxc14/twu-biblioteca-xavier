package com.twu.biblioteca.model.options;

import com.twu.biblioteca.model.Menu;

public class ListBooksOption extends Menu {

    public ListBooksOption(String name) {
        super(name);
    }

    @Override
    public void executeOption() {
        showTableHeaders();
        getBookService().listAvailableBooks();
    }

    private void showTableHeaders() {
        System.out.println("_________________________________________________________________________________________");
        System.out.println(String.format("|%50s|%15s|%20s|", "Book title", "Author", "Year of publication"));
        System.out.println("|=======================================================================================|");
    }
}
