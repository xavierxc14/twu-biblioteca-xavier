package com.twu.biblioteca;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BibliotecaAppTest {
    @Test
    public void welcomeMessageTest() throws Exception {
        assertEquals("Welcome customer!", new BibliotecaApp().welcomeMessage());
    }
}