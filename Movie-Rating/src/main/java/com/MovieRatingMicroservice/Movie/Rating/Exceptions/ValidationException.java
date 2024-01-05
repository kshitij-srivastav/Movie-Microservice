package com.MovieRatingMicroservice.Movie.Rating.Exceptions;

// ValidationException.java
public class ValidationException extends RuntimeException {
    public ValidationException(String message) {
        super(message);
    }
}

