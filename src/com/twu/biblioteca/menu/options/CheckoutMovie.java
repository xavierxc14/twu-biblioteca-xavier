package com.twu.biblioteca.menu.options;

import com.twu.biblioteca.menu.Menu;
import com.twu.biblioteca.model.Movie;
import com.twu.biblioteca.service.MovieService;

public class CheckoutMovie extends Menu {

    public CheckoutMovie() {
        super("5. Checkout a movie");
    }

    @Override
    public void executeOption() {
        MovieService movieService = new MovieService();
        Movie movie = movieService.obtainMovie();
        movieService.checkoutMovie(movie);
    }
}
