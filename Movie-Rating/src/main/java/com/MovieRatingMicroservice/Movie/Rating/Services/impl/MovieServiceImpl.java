package com.MovieRatingMicroservice.Movie.Rating.Services.impl;

import com.MovieRatingMicroservice.Movie.Rating.Exceptions.NotFoundException;
import com.MovieRatingMicroservice.Movie.Rating.Exceptions.ValidationException;
import com.MovieRatingMicroservice.Movie.Rating.Repository.MoviesRepository;
import com.MovieRatingMicroservice.Movie.Rating.Services.MovieService;
import com.MovieRatingMicroservice.Movie.Rating.models.Movies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    MoviesRepository moviesRepository;
    @Override
    public List<Movies> getAllMovies() {
      return   moviesRepository.findAll();
    }
    @Override
    public List<Movies> getMoviesByRating(int minRating, int page, int pageSize) {
        if (minRating < 0) {
            throw new ValidationException("Minimum rating must be greater than or equal to 0");
        }

        List<Movies> filteredMovies = moviesRepository.findByRatingGreaterThanEqual(minRating);

        if (filteredMovies.isEmpty()) {
            throw new NotFoundException("No movies found with the given rating");
        }

        // Implement pagination with the adjusted page size
        int startIndex = (page - 1) * pageSize;
        int endIndex = Math.min(startIndex + pageSize, filteredMovies.size());

        return filteredMovies.subList(startIndex, endIndex);
    }

    @Override
    public Movies findMovieByName(String movieName) {
       return  moviesRepository.findByMovie(movieName);

    }


    @Override
    public Movies addMovie(Movies movie) {
       return  moviesRepository.save(movie);
    }
}
