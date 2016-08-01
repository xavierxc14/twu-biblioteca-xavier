package com.twu.biblioteca.service;

import com.twu.biblioteca.model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookService {

    private static final String CHECKOUT_MESSAGE = "Thank you! Enjoy the book.";
    private static final String UNSUCCESSFUL_CHECKOUT_MESSAGE = "That book is not available.";
    private static final String RETURN_MESSAGE = "Thank you for returning the book.";
    private static final String UNSUCCESSFUL_RETURN_MESSAGE = "That is not a valid book to return.";

    private static BookService instance;

    private List<Book> availableBooks;
    private List<Book> checkedOutBooks;

    private BookService() {
        populateBooks();
    }

    public static BookService getInstance() {
        if (instance == null) {
            instance = new BookService();
        }
        return instance;
    }

    public void listAvailableBooks() {
        for (Book b : availableBooks) {
            b.print();
        }
    }

    private void populateBooks() {
        availableBooks = new ArrayList<Book>();
        checkedOutBooks = new ArrayList<Book>();
        Book scrum = new Book("Essential Scrum", "Kenneth S. Rubin", "2013");
        Book tdd = new Book("Test-driven Development: By Example", "Kent Beck", "2003");
        Book xp = new Book("Extreme Programming Explained: Embrace Change", "Kent Beck", "2009");
        availableBooks.add(tdd);
        availableBooks.add(scrum);
        checkedOutBooks.add(xp);
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
        System.out.println("Write the book name:");
        Scanner scanner = new Scanner(System.in);
        String bookName = scanner.nextLine().trim();
        System.out.println();
        return findBookByName(bookName);
    }

    public Book findBookByName(String name) {
        for (Book book : availableBooks) {
            if (name.equals(book.getName())) {
                return book;
            }
        }
        for (Book book : checkedOutBooks) {
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

    public List<Book> getAvailableBooks() {
        return availableBooks;
    }

    public void setAvailableBooks(List<Book> availableBooks) {
        this.availableBooks = availableBooks;
    }

    public List<Book> getCheckedOutBooks() {
        return checkedOutBooks;
    }

    public void setCheckedOutBooks(List<Book> checkedOutBooks) {
        this.checkedOutBooks = checkedOutBooks;
    }
}
