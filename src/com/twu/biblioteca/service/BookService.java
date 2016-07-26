package com.twu.biblioteca.service;

import com.twu.biblioteca.BibliotecaApp;
import com.twu.biblioteca.model.Author;
import com.twu.biblioteca.model.Book;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class BookService {

    private List<Book> books;

    public void listAllBooks() {
        for (Book b : books) {
            if (!b.isCheckedOut()) {
                b.print();
            }
        }
    }

    public void populateBooks() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2003);
        Book book = new Book("Test-driven Development: By Example", new Author("Kent Beck"), calendar.getTime());
        books = new ArrayList<Book>();
        books.add(book);
    }

    public void checkoutBook(Book book) {
        if (book == null || book.isCheckedOut()) {
            System.out.println(BibliotecaApp.UNSUCCESSFUL_CHECKOUT_MESSAGE);
        } else {
            book.setCheckedOut(true);
            System.out.println(BibliotecaApp.CHECKOUT_MESSAGE);
        }
    }

    public Book findBookByName(String name) {
        for (Book book : books) {
            if (name.equals(book.getName())) {
                return book;
            }
        }
        return null;
    }

    public void returnBook(Book book) {
        if (book != null && book.isCheckedOut()) {
            book.setCheckedOut(false);
            System.out.println(BibliotecaApp.RETURN_MESSAGE);
        } else {
            System.out.println(BibliotecaApp.UNSUCCESSFUL_RETURN_MESSAGE);
        }
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
