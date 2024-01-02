package com.MovieRatingMicroservice.Movie.Rating.Repository;

import com.MovieRatingMicroservice.Movie.Rating.models.Movies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MoviesRepository extends JpaRepository<Movies, Long> {
//    Movies findByName(String name);

        List<Movies> findByRatingGreaterThanEqual(int minRating);
        Movies findByMovie (String movieName);
}
