package com.MovieRatingMicroservice.Movie.Rating.Exceptions;

// NotFoundException.java
public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}

