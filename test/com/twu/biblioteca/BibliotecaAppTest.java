package com.twu.biblioteca;

import com.twu.biblioteca.model.Author;
import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.util.FileUtil;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BibliotecaAppTest {

    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private BibliotecaApp app;

    @Before
    public void setUp() throws Exception {
        app = new BibliotecaApp();
        app.populateBooks();
        System.setOut(new PrintStream(out));
    }

    @Test
    public void welcomeMessage() throws Exception {
        assertEquals(BibliotecaApp.WELCOME, app.welcomeMessage());
    }

    @Test
    public void listAllBooks() throws Exception {
        Book book = new Book("Scrum", new Author("A smart person"), new Date());
        book.setCheckedOut(true);
        app.getBooks().add(book);
        app.listAllBooks();
        assertEquals(FileUtil.load(BibliotecaApp.BOOK_FILE).get(0) + "\n", out.toString());
    }

    @Test
    public void menuOptions() throws Exception {
        String menu = readMenu();
        app.menuOptions();
        assertEquals(menu, out.toString());
    }

    @Test
    public void getMenuOption() throws Exception {
        ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());
        System.setIn(in);
        assertEquals(1, app.getMenuOption());
    }

    @Test
    public void invalidMenuOption() throws Exception {
        assertEquals(BibliotecaApp.INVALID_OPTION, app.invalidMenuOption());
    }

    @Test
    public void repeatMenu() throws Exception {
        String menu = readMenu();
        ByteArrayInputStream in = new ByteArrayInputStream("0".getBytes());
        System.setIn(in);
        app.repeatMenu();
        assertEquals(menu, out.toString());
    }

    private String readMenu() {
        List<String> menu = FileUtil.load(BibliotecaApp.MENU_FILE);
        StringBuilder sb = new StringBuilder();
        for (String line : menu) {
            sb.append(line).append("\n");
        }
        return sb.toString();
    }

    @Test
    public void checkoutBook() throws Exception {
        Book book = new Book();
        app.checkoutBook(book);
        assertEquals(true, book.isCheckedOut());
        assertEquals(BibliotecaApp.CHECKOUT_MESSAGE + "\n", out.toString());
    }

    @Test
    public void unsuccessfulCheckout() throws Exception {
        Book book = new Book();
        app.checkoutBook(book);
        out.reset();
        app.checkoutBook(book);
        assertEquals(BibliotecaApp.UNSUCCESSFUL_CHECKOUT_MESSAGE + "\n", out.toString());
    }

    @Test
    public void findBookByName() throws Exception {
        Book scrum = new Book("Scrum");
        String name = "Scrum";
        app.getBooks().add(new Book(name));
        assertEquals(scrum, app.findBookByName(name));
        assertEquals(null, app.findBookByName("other no listed"));
    }
}