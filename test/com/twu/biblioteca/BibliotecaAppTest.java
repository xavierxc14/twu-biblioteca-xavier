package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class BibliotecaAppTest {

    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private BibliotecaApp app;

    @Before
    public void setUp() throws Exception {
        app = new BibliotecaApp();
        System.setOut(new PrintStream(out));
    }

    @Test
    public void welcomeMessageTest() throws Exception {
        assertEquals("Welcome customer!", app.welcomeMessage());
    }

    @Test
    public void listAllBooksTest() throws Exception {
        app.listAllBooks();
        assertEquals("|Test-driven Development: By Example\t|\tKent Beck\t|\t2003|", out.toString());
    }
}