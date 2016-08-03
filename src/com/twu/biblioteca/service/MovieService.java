package com.twu.biblioteca.service;

import com.twu.biblioteca.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieService {

    private List<Movie> availableMovies;
    private List<Movie> checkedOutMovies;

    public MovieService() {
        populateMovies();
    }

    public void listAvailableMovies() {
        for (Movie m : availableMovies) {
            m.print();
        }
    }

    private void populateMovies() {
        availableMovies = new ArrayList<Movie>();
        checkedOutMovies = new ArrayList<Movie>();
        Movie movie = new Movie("The Hunger Games", "2012", "Gary Ross", 7);
        availableMovies.add(movie);
    }

    public boolean checkoutMovie(Movie movie) {
        if (availableMovies.contains(movie)) {
            availableMovies.remove(movie);
            checkedOutMovies.add(movie);
            return true;
        }
        return false;
    }
}
