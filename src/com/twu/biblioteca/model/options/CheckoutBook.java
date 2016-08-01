package com.twu.biblioteca.model.options;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Menu;
import com.twu.biblioteca.service.BookService;

public class CheckoutBook extends Menu {

    public CheckoutBook() {
        super("2. Checkout a book");
    }

    @Override
    public void executeOption() {
        BookService bookService = BookService.getInstance();
        Book searched = bookService.obtainBook();
        bookService.checkoutBook(searched);
    }
}
