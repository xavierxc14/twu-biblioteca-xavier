package com.twu.biblioteca.menu.options;

import com.twu.biblioteca.menu.Menu;
import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.User;
import com.twu.biblioteca.service.BookService;

public class ReturnBook extends Menu {

    public ReturnBook() {
        super("3. Return a book");
    }

    @Override
    public void executeOption() {
        User loggedIn = showLogin();
        if (loggedIn != null) {
            BookService bookService = new BookService();
            Book searched = bookService.obtainBook();
            bookService.returnBook(searched);
        } else {
            System.out.println("User not found!");
        }
    }
}
