package com.twu.biblioteca.menu.options;

import com.twu.biblioteca.menu.Menu;
import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.User;
import com.twu.biblioteca.service.BookService;
import com.twu.biblioteca.service.UserService;
import com.twu.biblioteca.util.UserInput;

public class CheckoutBook extends Menu {

    public CheckoutBook() {
        super("2. Checkout a book");
    }

    @Override
    public void executeOption() {
        String libraryNumber = UserInput.obtainInput("Write your library number: ");
        String password = UserInput.obtainInput("Write your password: ");
        User loggedIn = UserService.getInstance().login(libraryNumber, password);
        if (loggedIn != null) {
            BookService bookService = new BookService();
            Book searched = bookService.obtainBook();
            bookService.checkoutBook(searched);
        } else {
            System.out.println("User not found!");
        }
    }
}
