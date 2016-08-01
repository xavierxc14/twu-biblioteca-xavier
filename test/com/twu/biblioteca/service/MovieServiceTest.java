package com.twu.biblioteca.service;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class MovieServiceTest {

    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void setUp() throws Exception {
        System.setOut(new PrintStream(out));
    }

    @Test
    public void shouldListAvailableMovies() throws Exception {
        MovieService movieService = new MovieService();
        movieService.listAvailableMovies();
        assertEquals("|              The Hunger Games|           Gary Ross|                2012|         7|\n",
                out.toString());
    }

}