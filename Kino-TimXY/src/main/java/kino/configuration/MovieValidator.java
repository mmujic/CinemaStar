package kino.configuration;

import kino.model.entities.Movie;

public class MovieValidator {

    public static boolean isInvalidMovie(Movie movie) {
        if (movie.getName() == null || movie.getName().equals("") || !CommonValidators.isValidName(movie.getName())) {
            return true;
        }
        if (movie.getDescription() == null || movie.getDescription().equals("") || !CommonValidators.isValidName(movie.getName())) {
            return true;
        }
        if (movie.getDuration() == null || movie.getDuration() <= 0) {
            return true;
        } else
            return false;
    }
}
