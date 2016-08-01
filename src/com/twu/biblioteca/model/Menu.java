package com.twu.biblioteca.model;

import com.twu.biblioteca.service.BookService;

public abstract class Menu {

    private String name;

    private BookService bookService;

    public Menu(String name) {
        this.name = name;
        this.bookService = BookService.getInstance();
    }

    public abstract void executeOption();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BookService getBookService() {
        return bookService;
    }

    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }
}
