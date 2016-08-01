package com.twu.biblioteca.model.options;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Menu;
import com.twu.biblioteca.service.BookService;

public class ReturnBook extends Menu {

    public ReturnBook() {
        super("3. Return a book");
    }

    @Override
    public void executeOption() {
        BookService bookService = BookService.getInstance();
        Book searched = bookService.obtainBook();
        bookService.returnBook(searched);
    }
}
