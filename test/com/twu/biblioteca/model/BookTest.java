package com.twu.biblioteca.model;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class BookTest {

    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private Book book;
    private String bookAsString;

    @Before
    public void setUp() throws Exception {
        System.setOut(new PrintStream(out));
        book = new Book("Essential Scrum", "Kenneth S. Rubin", "2013");
        bookAsString = "|                                   Essential Scrum|    Kenneth S. Rubin|                2013|";
    }

    @Test
    public void shouldPrintABook() throws Exception {
        book.print();
        assertEquals(bookAsString + "\n", out.toString());
    }

    @Test
    public void shouldReturnAStringRepresentation() throws Exception {
        assertEquals(bookAsString, book.toString());
    }

    @Test
    public void shouldBeDifferentBooks() throws Exception {
        Book b = new Book("Test", "", "");
        assertFalse(b.equals(book));

    }

    @Test
    public void shouldReturnNameHashCode() throws Exception {
        assertEquals(book.getName().hashCode(), book.hashCode());
    }

}