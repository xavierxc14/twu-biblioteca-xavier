package com.twu.biblioteca.service;

import com.twu.biblioteca.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieService {

    private List<Movie> availableMovies;

    public void listAvailableMovies() {
        availableMovies = new ArrayList<Movie>();
        Movie movie = new Movie("The Hunger Games", "2012", "Gary Ross", 7);
        availableMovies.add(movie);
        for (Movie m : availableMovies) {
            m.print();
        }
    }
}
