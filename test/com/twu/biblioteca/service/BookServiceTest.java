package com.twu.biblioteca.service;

import com.twu.biblioteca.BibliotecaApp;
import com.twu.biblioteca.model.Author;
import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.util.FileUtil;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Date;

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
        Book book = new Book("Scrum", new Author("A smart person"), new Date());
        book.setCheckedOut(true);
        bookService.getBooks().add(book);
        bookService.listAllBooks();
        assertEquals(FileUtil.load(BibliotecaApp.BOOK_FILE).get(0) + "\n", out.toString());
    }

    @Test
    public void checkoutBook() throws Exception {
        Book book = new Book();
        bookService.checkoutBook(book);
        assertEquals(true, book.isCheckedOut());
        assertEquals(BibliotecaApp.CHECKOUT_MESSAGE + "\n", out.toString());
    }

    @Test
    public void unsuccessfulCheckout() throws Exception {
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
        checkoutBook();
        assertEquals(1, bookService.getBooks().size());
        Book book = bookService.getBooks().get(0);
        bookService.returnBook(book);
        assertEquals(false, book.isCheckedOut());
    }
}