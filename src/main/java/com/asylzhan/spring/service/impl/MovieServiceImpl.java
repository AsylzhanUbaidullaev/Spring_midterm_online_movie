package com.asylzhan.spring.service.impl;

import com.asylzhan.spring.entity.Movie;
import com.asylzhan.spring.repo.MovieRepo;
import com.asylzhan.spring.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    private MovieRepo movieRepo;

    @Override
    public List<Movie> getAllMovies() {
        return movieRepo.getAllBy();
    }

    @Override
    public List<Movie> getAllMoviesByGenre(String genre) {
        return movieRepo.getMovieByGenre(genre);
    }
}
