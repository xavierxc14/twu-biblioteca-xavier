package com.twu.biblioteca.model.options;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Menu;

import java.util.Scanner;

public class ReturnBookOption extends Menu {

    public ReturnBookOption(String name) {
        super(name);
    }

    @Override
    public void executeOption() {
        Book searched = obtainBook();
        getBookService().returnBook(searched);
    }

    private Book obtainBook() {
        System.out.println("Write the book name:");
        Scanner scanner = new Scanner(System.in);
        String bookName = scanner.nextLine().trim();
        System.out.println();
        return getBookService().findBookByName(bookName);
    }

}
