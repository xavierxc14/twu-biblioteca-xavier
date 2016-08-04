package com.twu.biblioteca.menu.options;

import com.twu.biblioteca.menu.Menu;
import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.User;
import com.twu.biblioteca.service.BookService;
import com.twu.biblioteca.service.UserService;
import com.twu.biblioteca.util.UserInput;

public class ReturnBook extends Menu {

    public ReturnBook() {
        super("3. Return a book");
    }

    @Override
    public void executeOption() {
        String libraryNumber = UserInput.obtainInput("Write your library number: ");
        String password = UserInput.obtainInput("Write your password: ");
        UserService userService = new UserService();
        User loggedIn = userService.login(libraryNumber, password);
        if (loggedIn != null) {
            BookService bookService = new BookService();
            Book searched = bookService.obtainBook();
            bookService.returnBook(searched);
        } else {
            System.out.println("User not found!");
        }
    }
}
