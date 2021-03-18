package com.asylzhan.spring.controller;

import com.asylzhan.spring.entity.Movie;
import com.asylzhan.spring.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;

@Controller
public class MovieController {
    @Autowired
    private MovieService movieService;

    public ArrayList<Movie> getAllMovies() {
        return (ArrayList<Movie>) movieService.getAllMovies();
    }

    public ArrayList<Movie> getAllMoviesByGenre(String genre) {
        return (ArrayList<Movie>) movieService.getAllMoviesByGenre(genre);
    }
}
