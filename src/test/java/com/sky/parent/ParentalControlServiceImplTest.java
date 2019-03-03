package com.sky.parent;

import com.sky.customer.MovieService;
import com.sky.customer.TitleNotFoundException;
import com.sky.stubs.MovieServiceStub;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ParentalControlServiceImplTest {

    private MovieService movieService = new MovieServiceStub();
    private ParentalControlServiceImpl parentalService;

    @Before
    public void setup() {
        parentalService = new ParentalControlServiceImpl(movieService);
    }

    @Test
    public void checkMovieAllowedToWatch() {

        try {
            boolean isAllowed = parentalService.getMovieAllowedStatus("U", "MV_100001");
            assertTrue(isAllowed);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void checkMovieNotAllowedToWatch() {
        try {
            boolean isAllowed = parentalService.getMovieAllowedStatus("U", "MV_100002");
            assertFalse(isAllowed);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void checkError() {
        try {
            parentalService.getMovieAllowedStatus("U", "MV_100012");
            new AssertionError();
        } catch (Exception e) {
            assert (e instanceof TitleNotFoundException);
        }
    }
}
