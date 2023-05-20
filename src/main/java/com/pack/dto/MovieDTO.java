package com.pack.dto;

import java.io.IOException;
import java.util.List;

import com.pack.entity.Movie;
import com.pack.entity.MovieDetails;


public interface MovieDTO {
	public Movie createMovie(MovieDetails movie) throws IOException;
	public Movie getMovieById(String id);
	public List<MovieDetails> getAllMovies();
	public MovieDetails updateMovie(MovieDetails movie) throws NullPointerException, IOException;
	public void deleteMovieById(String id);
}
