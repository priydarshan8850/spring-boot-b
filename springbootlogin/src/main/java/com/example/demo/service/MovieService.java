package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Movie;



public interface MovieService {
	
	List<Movie> getAllMovies();

	void saveMovie(Movie movie);

	Movie getMovieById(long id);

	void deleteMovieById(long id);
}
