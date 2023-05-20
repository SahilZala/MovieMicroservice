package com.pack.service;

import java.util.List;

import com.pack.entity.Movie;

public interface MovieService {
	public Movie createMovie(Movie movie);
	public Movie getMovieById(String id);
	public List<Movie> getAllMovies();
	public Movie updateMovie(Movie movie);
	public void deleteMovieById(String id);
}
