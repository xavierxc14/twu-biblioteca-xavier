package com.twu.biblioteca.service;

import com.twu.biblioteca.model.Movie;
import com.twu.biblioteca.util.UserInput;

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

    public Movie checkoutMovie(Movie movie) {
        if (availableMovies.contains(movie)) {
            availableMovies.remove(movie);
            checkedOutMovies.add(movie);
            return movie;
        }
        return null;
    }

    public Movie obtainMovie() {
        String movieName = UserInput.obtainInput("Write the movie name: ");
        return findBookByName(movieName, availableMovies);
    }

    private Movie findBookByName(String name, List<Movie> movies) {
        for (Movie movie : movies) {
            if (name.equals(movie.getName())) {
                return movie;
            }
        }
        return null;
    }
}
