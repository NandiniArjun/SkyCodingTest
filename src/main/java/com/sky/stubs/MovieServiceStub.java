package com.sky.stubs;

import com.sky.customer.MovieService;
import com.sky.customer.TechnicalFailureException;
import com.sky.customer.TitleNotFoundException;

import java.util.HashMap;
import java.util.Map;

public class MovieServiceStub implements MovieService {

    private Map<String, String> movieDetails = new HashMap<String, String>();

    public MovieServiceStub() {
        movieDetails.put("MV_100001", "U(0)");
        movieDetails.put("MV_100002", "PG(1)");
        movieDetails.put("MV_100003", "TWELVE(12)");
        movieDetails.put("MV_100004", "FIFTEEN(15)");
        movieDetails.put("MV_100005", "EIGHTEEN(18)");
        movieDetails.put("MV_100006", "UG(2)");
    }

    public String getParentalControlLevel(String movieId)
            throws TitleNotFoundException, TechnicalFailureException {

        if (movieDetails.containsKey(movieId)) {
            return movieDetails.get(movieId).substring(0, movieDetails.get(movieId).indexOf('('));
        } else {
            throw new TitleNotFoundException("Movie number " + movieId + " is invalid");
        }
    }
}
