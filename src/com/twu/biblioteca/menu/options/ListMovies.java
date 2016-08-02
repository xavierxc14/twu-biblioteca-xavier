package com.twu.biblioteca.menu.options;

import com.twu.biblioteca.menu.Menu;
import com.twu.biblioteca.service.MovieService;

public class ListMovies extends Menu {

    public ListMovies() {
        super("4. List movies");
    }

    @Override
    public void executeOption() {
        showTableHeaders();
        MovieService movieService = new MovieService();
        movieService.listAvailableMovies();
    }

    private void showTableHeaders() {
        System.out.println("___________________________________________________________________________");
        System.out.println(String.format("|%30s|%20s|%10s|%10s|", "Movie name", "Director", "Year", "Rating"));
        System.out.println("|=========================================================================|");
    }
}
