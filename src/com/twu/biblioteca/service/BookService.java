package com.twu.biblioteca.service;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.util.UserInput;

import java.util.ArrayList;
import java.util.List;

public class BookService {

    private static final String CHECKOUT_MESSAGE = "Thank you! Enjoy the book.";
    private static final String UNSUCCESSFUL_CHECKOUT_MESSAGE = "That book is not available.";
    private static final String RETURN_MESSAGE = "Thank you for returning the book.";
    private static final String UNSUCCESSFUL_RETURN_MESSAGE = "That is not a valid book to return.";

    private static List<Book> availableBooks;
    private static List<Book> checkedOutBooks;

    public static void populateBooks() {
        availableBooks = new ArrayList<Book>();
        checkedOutBooks = new ArrayList<Book>();
        Book scrum = new Book("Essential Scrum", "Kenneth S. Rubin", "2013");
        Book tdd = new Book("Test-driven Development: By Example", "Kent Beck", "2003");
        Book xp = new Book("Extreme Programming Explained: Embrace Change", "Kent Beck", "2009");
        availableBooks.add(tdd);
        availableBooks.add(scrum);
        checkedOutBooks.add(xp);
    }

    public void listAvailableBooks() {
        for (Book b : availableBooks) {
            b.print();
        }
    }

    public void checkoutBook(Book book) {
        if (book == null || !availableBooks.contains(book)) {
            System.out.println(UNSUCCESSFUL_CHECKOUT_MESSAGE);
        } else {
            availableBooks.remove(book);
            checkedOutBooks.add(book);
            System.out.println(CHECKOUT_MESSAGE);
        }
    }

    public Book obtainBook() {
        String bookName = UserInput.obtainInput("Write the book name: ");
        Book book = findBookByName(bookName, availableBooks);
        book = book != null ? book : findBookByName(bookName, checkedOutBooks);
        return book;
    }

    private Book findBookByName(String name, List<Book> books) {
        for (Book book : books) {
            if (name.equals(book.getName())) {
                return book;
            }
        }
        return null;
    }

    public void returnBook(Book book) {
        if (book != null && checkedOutBooks.contains(book)) {
            checkedOutBooks.remove(book);
            availableBooks.add(book);
            System.out.println(RETURN_MESSAGE);
        } else {
            System.out.println(UNSUCCESSFUL_RETURN_MESSAGE);
        }
    }
}
