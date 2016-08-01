package com.twu.biblioteca.service;

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
        bookService = BookService.getInstance();
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
    public void shouldDisplayAMessageOnBookCheckout() throws Exception {
        Book book = new Book("Test-driven Development: By Example", "", "");
        bookService.checkoutBook(book);
        assertEquals(0, bookService.getAvailableBooks().size());
        assertEquals("Thank you! Enjoy the book.\n", out.toString());
    }

    @Test
    public void shouldDisplayAMessageOnUnsuccessfulBookCheckout() throws Exception {
        Book book = new Book("Scrum", "", "");
        bookService.checkoutBook(book);
        assertEquals("That book is not available.\n", out.toString());
    }

    @Test
    public void shouldFindABookByName() throws Exception {
        Book scrum = new Book("Scrum", "", "");
        bookService.getAvailableBooks().add(scrum);
        assertEquals(scrum, bookService.findBookByName("Scrum"));
        assertEquals(null, bookService.findBookByName("other no listed"));
    }

    @Test
    public void shouldDisplayAMessageOnBookReturn() throws Exception {
        assertEquals(1, bookService.getAvailableBooks().size());
        Book book = bookService.getAvailableBooks().get(0);
        bookService.checkoutBook(book);
        assertEquals(1, bookService.getCheckedOutBooks().size());
        out.reset();
        bookService.returnBook(book);
        assertEquals("Thank you for returning the book.\n", out.toString());
    }

    @Test
    public void shouldDisplayAMessageOnUnsuccessfulBookReturn() throws Exception {
        Book book = new Book("An incredible book", "", "");
        bookService.returnBook(book);
        assertEquals("That is not a valid book to return.\n", out.toString());
    }
}