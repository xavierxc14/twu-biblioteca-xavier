package com.twu.biblioteca;

import com.twu.biblioteca.model.Author;
import com.twu.biblioteca.model.Book;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class BibliotecaApp {

    public static void main(String[] args) {
        BibliotecaApp app = new BibliotecaApp();
        System.out.println(app.welcomeMessage());
        app.listAllBooks();
    }

    public String welcomeMessage() {
        return "Welcome customer!";
    }

    public void listAllBooks() {
        Book book = new Book();
        book.setName("Test-driven Development: By Example");
        Author author = new Author("Kent Beck");
        book.setAuthor(author);
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2003);
        book.setPublication(calendar.getTime());
        List<Book> books = new ArrayList<Book>();
        books.add(book);
        for (Book b : books) {
            b.print();
        }
    }
}
