package com.MovieRatingMicroservice.Movie.Rating.Services;

import com.MovieRatingMicroservice.Movie.Rating.models.Movies;

import java.util.List;

public interface MovieService {
    List<Movies> getAllMovies();

    Movies addMovie(Movies movie);
    List<Movies> getMoviesByRating(int minRating, int page, int pageSize);
    Movies findMovieByName(String movieName);


}
