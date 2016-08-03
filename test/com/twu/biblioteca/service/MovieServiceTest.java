package com.twu.biblioteca.service;

import com.twu.biblioteca.model.Movie;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

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
    public void shouldReturnTheMovieCheckedOut() throws Exception {
        Movie theHungerGames = new Movie("The Hunger Games", "2012", "Gary Ross", 7);
        assertEquals(theHungerGames, movieService.checkoutMovie(theHungerGames));
    }

    @Test
    public void shouldReturnNullWhenMovieWasNotCheckedOut() throws Exception {
        assertNull(movieService.checkoutMovie(new Movie("Test", "", "", 0)));
    }

    @Test
    public void shouldFindAMovieByName() throws Exception {
        Movie theHungerGames = new Movie("The Hunger Games", "2012", "Gary Ross", 7);
        ByteArrayInputStream in = new ByteArrayInputStream("The Hunger Games".getBytes());
        System.setIn(in);
        assertEquals(theHungerGames, movieService.obtainMovie());
        in = new ByteArrayInputStream("Other/Not listed".getBytes());
        System.setIn(in);
        assertNull(movieService.obtainMovie());
    }
}