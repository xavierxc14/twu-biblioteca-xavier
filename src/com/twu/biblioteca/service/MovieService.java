package com.twu.biblioteca.service;

import com.twu.biblioteca.model.Movie;
import com.twu.biblioteca.util.UserInput;

import java.util.ArrayList;
import java.util.List;

public class MovieService {

    private static List<Movie> availableMovies;
    private static List<Movie> checkedOutMovies;

    public static void populateMovies() {
        availableMovies = new ArrayList<Movie>();
        checkedOutMovies = new ArrayList<Movie>();
        Movie movie = new Movie("The Hunger Games", "2012", "Gary Ross", 7);
        availableMovies.add(movie);
    }

    public void listAvailableMovies() {
        for (Movie m : availableMovies) {
            m.print();
        }
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
            if (movie.getName().equals(name)) {
                return movie;
            }
        }
        return null;
    }
}
