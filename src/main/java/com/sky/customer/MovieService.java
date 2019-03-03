package com.sky.customer;

public interface MovieService {

    enum Level {
        U(0), PG(1), TWELVE(12), FIFTEEN(15), EIGHTEEN(18);
        private final int value;

        Level(int intValue) {
            this.value = intValue;
        }

        public int getValue() {
            return value;
        }
    }

    String getParentalControlLevel(String movieId) throws TitleNotFoundException, TechnicalFailureException;
}
