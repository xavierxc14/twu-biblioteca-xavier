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
    public void shouldListAvailableBooks() throws Exception {
        bookService.listAvailableBooks();
        assertEquals("|               Test-driven Development: By Example|      Kent Beck|                2003|" + "\n",
                out.toString());
    }

    @Test
    public void shouldCheckoutABook() throws Exception {
        Book book = new Book("Test-driven Development: By Example", "", "");
        bookService.checkoutBook(book);
        assertEquals(0, bookService.getAvailableBooks().size());
        assertEquals(BibliotecaApp.CHECKOUT_MESSAGE + "\n", out.toString());
    }

    @Test
    public void shouldDisplayUnsuccessfulCheckoutBookMessage() throws Exception {
        Book book = new Book("Scrum", "", "");
        bookService.checkoutBook(book);
        assertEquals(BibliotecaApp.UNSUCCESSFUL_CHECKOUT_MESSAGE + "\n", out.toString());
    }

    @Test
    public void shouldFindABookByName() throws Exception {
        Book scrum = new Book("Scrum", "", "");
        bookService.getAvailableBooks().add(scrum);
        assertEquals(scrum, bookService.findBookByName("Scrum"));
        assertEquals(null, bookService.findBookByName("other no listed"));
    }

    @Test
    public void shouldReturnABook() throws Exception {
        assertEquals(1, bookService.getAvailableBooks().size());
        Book book = bookService.getAvailableBooks().get(0);
        bookService.checkoutBook(book);
        out.reset();
        bookService.returnBook(book);
        assertEquals(false, book.isCheckedOut());
        assertEquals(BibliotecaApp.RETURN_MESSAGE + "\n", out.toString());
    }

    @Test
    public void shouldDisplayUnsuccessfulReturnBookMessage() throws Exception {
        Book book = new Book("An incredible book", "", "");
        bookService.returnBook(book);
        assertEquals(BibliotecaApp.UNSUCCESSFUL_RETURN_MESSAGE + "\n", out.toString());
    }
}