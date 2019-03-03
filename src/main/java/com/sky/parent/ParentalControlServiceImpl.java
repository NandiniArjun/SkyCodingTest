package com.sky.parent;

import com.sky.customer.MovieService;
import com.sky.customer.TechnicalFailureException;
import com.sky.customer.TitleNotFoundException;

public class ParentalControlServiceImpl implements ParentalControlService {

    private MovieService movieService;

    public ParentalControlServiceImpl(MovieService movieService) {
        this.movieService = movieService;
    }

    public boolean getMovieAllowedStatus(String level, String movieId) {
        try {
            return (((MovieService.Level.valueOf(movieService.getParentalControlLevel(movieId))).getValue()
                    <= (MovieService.Level.valueOf(level)).getValue()));
        } catch (TitleNotFoundException e) {
            throw new RuntimeException(e.getMessage());
        } catch (TechnicalFailureException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}