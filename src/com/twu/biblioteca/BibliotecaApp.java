package com.twu.biblioteca;

import com.twu.biblioteca.model.Book;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaApp {

    public static void main(String[] args) {
        System.out.println("Hello, world!");
    }


    public String welcomeMessage() {
        return "Welcome customer!";
    }

    public void listAllBooks() {
        Book book = new Book();
        book.setName("Test-driven Development: By Example");
        List<Book> books = new ArrayList<Book>();
        books.add(book);
        for (Book b : books) {
            System.out.print(b.toString());
        }
    }
}
