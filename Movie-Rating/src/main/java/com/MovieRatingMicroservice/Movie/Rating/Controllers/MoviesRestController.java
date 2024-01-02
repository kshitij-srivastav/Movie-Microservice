package com.MovieRatingMicroservice.Movie.Rating.Controllers;

import com.MovieRatingMicroservice.Movie.Rating.Services.MovieService;
import com.MovieRatingMicroservice.Movie.Rating.models.Movies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v0/")
public class MoviesRestController {
    @Autowired
    MovieService movieService;

    @GetMapping("movies")
    public List<Movies> getAllMovies(){
       return  movieService.getAllMovies();
    }
    @PostMapping("movies")
    public Movies addMovie(@RequestBody Movies movie) {
        movieService.addMovie(movie);
        return movie;
    }
    @GetMapping("moviesFilter")
    public List<Movies> getMoviesByRating(
            @RequestParam(name = "minRating", defaultValue = "0") int minRating,
            @RequestParam(name = "page", defaultValue = "1") int page,
            @RequestParam(name = "pageSize", defaultValue = "10") int pageSize) {

        return movieService.getMoviesByRating(minRating, page, pageSize);
    }
    @GetMapping("byName")
    public Movies getMovieByName(
            @RequestParam(name ="movieName",defaultValue = "") String movieName
    ){
        return movieService.findMovieByName(movieName);
    }
    @GetMapping("health")
    public String health(){
        return "Hello from the backend";
    }
}
