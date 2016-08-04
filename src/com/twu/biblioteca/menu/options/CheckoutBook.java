package com.twu.biblioteca.menu.options;

import com.twu.biblioteca.menu.Menu;
import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.User;
import com.twu.biblioteca.service.BookService;

public class CheckoutBook extends Menu {

    public CheckoutBook() {
        super("2. Checkout a book");
    }

    @Override
    public void executeOption() {
        User loggedIn = showLogin();
        if (loggedIn != null) {
            BookService bookService = new BookService();
            Book searched = bookService.obtainBook();
            bookService.checkoutBook(searched);
        } else {
            System.out.println("User not found!");
        }
    }
}
