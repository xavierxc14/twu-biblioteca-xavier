package com.twu.biblioteca.service;

import com.twu.biblioteca.BibliotecaApp;
import com.twu.biblioteca.model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookService {

    private List<Book> availableBooks;
    private List<Book> checkedOutBooks;

    public void listAvailableBooks() {
        for (Book b : availableBooks) {
            b.print();
        }
    }

    public void populateBooks() {
        Book book = new Book("Test-driven Development: By Example", "Kent Beck", "2003");
        availableBooks = new ArrayList<Book>();
        checkedOutBooks = new ArrayList<Book>();
        availableBooks.add(book);
    }

    public void checkoutBook(Book book) {
        if (book == null || !availableBooks.contains(book)) {
            System.out.println(BibliotecaApp.UNSUCCESSFUL_CHECKOUT_MESSAGE);
        } else {
            availableBooks.remove(book);
            checkedOutBooks.add(book);
            System.out.println(BibliotecaApp.CHECKOUT_MESSAGE);
        }
    }

    public Book findBookByName(String name) {
        for (Book book : availableBooks) {
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
            System.out.println(BibliotecaApp.RETURN_MESSAGE);
        } else {
            System.out.println(BibliotecaApp.UNSUCCESSFUL_RETURN_MESSAGE);
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
