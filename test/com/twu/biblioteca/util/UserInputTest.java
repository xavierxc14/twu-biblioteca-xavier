package com.twu.biblioteca.util;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class UserInputTest {

    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void setUp() throws Exception {
        System.setOut(new PrintStream(out));
    }

    @Test
    public void shouldObtainUserInput() throws Exception {
        ByteArrayInputStream in = new ByteArrayInputStream("hi".getBytes());
        System.setIn(in);
        assertEquals("hi", UserInput.obtainInput("Write the product name: "));
    }
}