package com.twu.biblioteca.service;

import com.twu.biblioteca.model.Book;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class BookServiceTest {

    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private BookService bookService;

    private Book tdd;

    @Before
    public void setUp() throws Exception {
        System.setOut(new PrintStream(out));
        bookService = BookService.getInstance();
        tdd = new Book("Test-driven Development: By Example", "Kent Beck", "2003");
    }

    @Test
    public void shouldListAvailableBooks() throws Exception {
        bookService.listAvailableBooks();
        assertEquals("|                                   Essential Scrum|    Kenneth S. Rubin|                2013|\n" +
                        "|               Test-driven Development: By Example|           Kent Beck|                2003|\n",
                out.toString());
    }

    @Test
    public void shouldDisplayAMessageOnBookCheckout() throws Exception {
        bookService.checkoutBook(tdd);
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
        ByteArrayInputStream in = new ByteArrayInputStream("Test-driven Development: By Example".getBytes());
        System.setIn(in);
        assertEquals(tdd, bookService.obtainBook());
        in = new ByteArrayInputStream("Other/Not listed".getBytes());
        System.setIn(in);
        assertEquals(null, bookService.obtainBook());
    }

    @Test
    public void shouldDisplayAMessageOnBookReturn() throws Exception {
        bookService.checkoutBook(tdd);
        out.reset();
        bookService.returnBook(tdd);
        assertEquals("Thank you for returning the book.\n", out.toString());
    }

    @Test
    public void shouldDisplayAMessageOnUnsuccessfulBookReturn() throws Exception {
        Book book = new Book("An incredible book", "", "");
        bookService.returnBook(book);
        assertEquals("That is not a valid book to return.\n", out.toString());
    }
}