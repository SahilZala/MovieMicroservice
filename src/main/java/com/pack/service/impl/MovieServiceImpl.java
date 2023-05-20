package com.pack.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pack.entity.Movie;
import com.pack.repository.MovieRepository;
import com.pack.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	MovieRepository movieRepo;
	
	@Override
	public Movie createMovie(Movie movie) {	
		return movieRepo.save(movie);
	}

	@Override
	public Movie getMovieById(String id) {
		return movieRepo.findById(id).get();
	}

	@Override
	public List<Movie> getAllMovies() {
		return movieRepo.findAll();
	}

	@Override
	public Movie updateMovie(Movie movie) {
		return movieRepo.save(movie);
	}

	@Override
	public void deleteMovieById(String id) {
		movieRepo.deleteById(id);
	}
}
