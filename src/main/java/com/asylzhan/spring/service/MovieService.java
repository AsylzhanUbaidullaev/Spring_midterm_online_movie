package com.asylzhan.spring.service;

import com.asylzhan.spring.entity.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> getAllMovies();
    List<Movie> getAllMoviesByGenre(String genre);
}
