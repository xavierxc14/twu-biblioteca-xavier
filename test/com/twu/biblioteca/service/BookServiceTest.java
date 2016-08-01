package com.twu.biblioteca.service;

import com.twu.biblioteca.BibliotecaApp;
import com.twu.biblioteca.model.Book;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class BookServiceTest {

    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private BookService bookService;

    @Before
    public void setUp() throws Exception {
        bookService = new BookService();
        bookService.populateBooks();
        System.setOut(new PrintStream(out));
    }

    @Test
    public void listAllBooks() throws Exception {
        Book book = new Book("Scrum", "A smart person", "2016");
        book.setCheckedOut(true);
        bookService.getBooks().add(book);
        bookService.listAllBooks();
        assertEquals("|               Test-driven Development: By Example|      Kent Beck|                2003|" + "\n", out.toString());
    }

    @Test
    public void checkoutBook() throws Exception {
        Book book = new Book();
        bookService.checkoutBook(book);
        assertEquals(true, book.isCheckedOut());
        assertEquals(BibliotecaApp.CHECKOUT_MESSAGE + "\n", out.toString());
    }

    @Test
    public void unsuccessfulCheckoutBook() throws Exception {
        Book book = new Book();
        bookService.checkoutBook(book);
        out.reset();
        bookService.checkoutBook(book);
        assertEquals(BibliotecaApp.UNSUCCESSFUL_CHECKOUT_MESSAGE + "\n", out.toString());
    }

    @Test
    public void findBookByName() throws Exception {
        Book scrum = new Book("Scrum");
        String name = "Scrum";
        bookService.getBooks().add(new Book(name));
        assertEquals(scrum, bookService.findBookByName(name));
        assertEquals(null, bookService.findBookByName("other no listed"));
    }

    @Test
    public void returnBook() throws Exception {
        assertEquals(1, bookService.getBooks().size());
        Book book = bookService.getBooks().get(0);
        bookService.checkoutBook(book);
        out.reset();
        bookService.returnBook(book);
        assertEquals(false, book.isCheckedOut());
        assertEquals(BibliotecaApp.RETURN_MESSAGE + "\n", out.toString());
    }

    @Test
    public void unsuccessfulReturnBook() throws Exception {
        Book book = new Book("An incredible book");
        bookService.returnBook(book);
        assertEquals(BibliotecaApp.UNSUCCESSFUL_RETURN_MESSAGE + "\n", out.toString());
    }
}