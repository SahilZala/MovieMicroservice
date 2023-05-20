package com.pack.controller;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pack.dto.MovieDTO;
import com.pack.entity.Movie;
import com.pack.entity.MovieDetails;
import com.pack.util.APIPaths;
import com.pack.util.AppUtility;

@RestController
@CrossOrigin
@RequestMapping("movie")
public class MovieController {
	
	@Autowired
	MovieDTO movieDto;
	
	
	private static final Logger log = LoggerFactory.getLogger(MovieController.class);

	
	@PostMapping(APIPaths.CREATE_MOVIE)
	public ResponseEntity<Movie> createMovie(@RequestBody MovieDetails movie) throws IOException
	{
		movie.setId(AppUtility.getRandomeId());
		log.info("create movie");
		log.info(movie.toString());
		return new ResponseEntity<>(movieDto.createMovie(movie),HttpStatus.OK);
	}
	
	@GetMapping(APIPaths.GET_ALL_MOVIE)
	public ResponseEntity<List<MovieDetails>> getAllMovie()
	{
		return new ResponseEntity<>(movieDto.getAllMovies(),HttpStatus.OK);
	}
	
	@PutMapping(APIPaths.UPDATE_MOVIE)
	public ResponseEntity<MovieDetails> updateMovie(@RequestBody MovieDetails movie) throws IOException
	{
		return new ResponseEntity<>(movieDto.updateMovie(movie),HttpStatus.OK);
	}
}

