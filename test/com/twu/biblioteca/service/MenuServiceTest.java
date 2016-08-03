package com.twu.biblioteca.service;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MenuServiceTest {

    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private MenuService menuService;
    private String menu;

    @Before
    public void setUp() throws Exception {
        menuService = new MenuService();
        System.setOut(new PrintStream(out));
        menu = "Menu:\n" +
                "0. Quit\n" +
                "1. List books\n" +
                "2. Checkout a book\n" +
                "3. Return a book\n" +
                "4. List movies\n" +
                "5. Checkout a movie\n" +
                "Select an option: ";
    }

    @Test
    public void shouldDisplayWelcomeMessage() throws Exception {
        assertEquals("Welcome customer!", menuService.displayWelcomeMessage());
    }

    @Test
    public void shouldDisplayMenuAndQuit() throws Exception {
        ByteArrayInputStream in = new ByteArrayInputStream("0".getBytes());
        System.setIn(in);
        menuService.displayMenu();
        assertEquals(menu + "\n\n\n", out.toString());
    }

    @Test
    public void shouldAceptOnlyNumbers() throws Exception {
        ByteArrayInputStream in = new ByteArrayInputStream("dfd#@".getBytes());
        System.setIn(in);
        int option = menuService.displayMenu();
        assertTrue(out.toString().contains("Only numbers are allowed!"));
        assertEquals(Integer.MAX_VALUE, option);
    }
}