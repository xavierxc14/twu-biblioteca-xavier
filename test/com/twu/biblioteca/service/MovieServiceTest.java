package com.twu.biblioteca.service;

import com.twu.biblioteca.model.Movie;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class MovieServiceTest {

    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private MovieService movieService;

    @Before
    public void setUp() throws Exception {
        System.setOut(new PrintStream(out));
        movieService = new MovieService();
    }

    @Test
    public void shouldDisplayAvailableMovies() throws Exception {
        movieService.listAvailableMovies();
        assertEquals("|              The Hunger Games|           Gary Ross|      2012|         7|\n",
                out.toString());
    }

    @Test
    public void shouldReturnFalseOnMovieCheckout() throws Exception {
        assertFalse(movieService.checkoutMovie(new Movie("Test", "", "", 0)));
    }

    @Test
    public void shouldReturnTrueOnMovieCheckout() throws Exception {
        assertTrue(movieService.checkoutMovie(new Movie("The Hunger Games", "2012", "Gary Ross", 7)));
    }
}