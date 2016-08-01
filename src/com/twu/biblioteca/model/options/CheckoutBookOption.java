package com.twu.biblioteca.model.options;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Menu;
import com.twu.biblioteca.service.BookService;

public class CheckoutBookOption extends Menu {

    public CheckoutBookOption(String name) {
        super(name);
    }

    @Override
    public void executeOption() {
        BookService bookService = BookService.getInstance();
        Book searched = bookService.obtainBook();
        bookService.checkoutBook(searched);
    }
}
