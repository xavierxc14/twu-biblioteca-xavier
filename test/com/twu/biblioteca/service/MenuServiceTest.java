package com.twu.biblioteca.service;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

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
                "Select an option: ";
    }

    @Test
    public void shouldDisplayWelcomeMessage() throws Exception {
        assertEquals("Welcome customer!", menuService.displayWelcomeMessage());
    }

    @Test
    public void shouldDisplayMenuOptions() throws Exception {
        menuService.displayMenuOptions();
        assertEquals(menu, out.toString());
    }

    @Test
    public void shouldReturnMenuOption() throws Exception {
        ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());
        System.setIn(in);
        assertEquals(1, menuService.getMenuOption());

    }

    @Test
    public void displayMenuUntilQuit() throws Exception {
        ByteArrayInputStream in = new ByteArrayInputStream("0".getBytes());
        System.setIn(in);
        menuService.displayMenuUntilQuit();
        assertEquals(menu + "\n", out.toString());
    }
}