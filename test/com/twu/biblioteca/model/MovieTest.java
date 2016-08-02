package com.twu.biblioteca.model;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class MovieTest {

    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private Movie movie;
    private String movieAsString;

    @Before
    public void setUp() throws Exception {
        System.setOut(new PrintStream(out));
        movie = new Movie("The Hunger Games", "2012", "Gary Ross", 7);
        movieAsString = "|              The Hunger Games|           Gary Ross|      2012|         7|";
    }

    @Test
    public void shouldPrintABook() throws Exception {
        movie.print();
        assertEquals(movieAsString + "\n", out.toString());
    }

    @Test
    public void shouldReturnAStringRepresentation() throws Exception {
        assertEquals(movieAsString, movie.toString());
    }

    @Test
    public void shouldBeDifferentBooks() throws Exception {
        Movie m = new Movie("Test", "", "", 0);
        assertFalse(m.equals(movie));

    }

    @Test
    public void shouldReturnNameHashCode() throws Exception {
        assertEquals(movie.getName().hashCode(), movie.hashCode());
    }

}