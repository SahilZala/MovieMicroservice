package com.pack.dto.impl;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pack.dto.MovieDTO;
import com.pack.dto.MovieJsonDTO;
import com.pack.entity.Movie;
import com.pack.entity.MovieDetails;
import com.pack.service.MovieService;
import com.pack.util.AppUtility;

@Service
public class MovieDTOImpl implements MovieDTO,MovieJsonDTO{

	@Autowired
	MovieService movieService;
	
	
	private static final Logger log = LoggerFactory.getLogger(MovieDTOImpl.class);

	
	@Override
	public Movie createMovie(MovieDetails movie) throws IOException {
		createMovieFolderandFile(movie.getId());
		writeJsonFile(movie);
		log.info("movie created");
		
		return movieService.createMovie(
				new Movie(movie.getId(),movie.getCategory(),movie.getActivation())
				);
	}

	@Override
	public Movie getMovieById(String id) {
		Movie m = movieService.getMovieById(id);
		log.info("get movie called");
		return m; 
	}

	@Override
	public List<MovieDetails> getAllMovies() {
		List<MovieDetails> list = movieService.getAllMovies().stream().map(d->{
			try {
				return fetchFromJsonFile(d.getId());
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			}
		}).collect(Collectors.toList()).stream().dropWhile(Objects::isNull).collect(Collectors.toList());
		log.info("get all movies");
		return list;
	}

	@Override
	public MovieDetails updateMovie(MovieDetails movie) throws IOException {
		writeJsonFile(movie);
		log.info("movie updated");
		return movie; 
	}

	@Override
	public void deleteMovieById(String id) {
		
		movieService.deleteMovieById(id);
		log.info("movie deleted");
		
	}
	@Override
	public void createMovieFolderandFile(String id)
	{
		StringBuilder val = new StringBuilder("");
		for(String i :id.split("-"))
			val.append(i);
		File f = new File(AppUtility.DIRECTORY_PATH+""+val);
		f.mkdir();
		new File(f.getAbsolutePath()+"/landscap").mkdir();
		new File(f.getAbsolutePath()+"/portrait").mkdir();
		
			
		File jsonFile = new File(AppUtility.DIRECTORY_PATH+""+val+"/metadata.json");
		try {
			if(jsonFile.createNewFile())
				log.info("metadata.file created.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void writeJsonFile(MovieDetails movieDetails) throws IOException {
		ObjectMapper obj = new ObjectMapper();
		StringBuilder val = new StringBuilder("");
		for(String i : movieDetails.getId().split("-"))
			val.append(i);
		
		FileWriter file = new FileWriter(AppUtility.DIRECTORY_PATH+""+val+"/metadata.json");
			
		file.write(obj.writeValueAsString(movieDetails));
		file.close();
		
	}

	@Override
	public MovieDetails fetchFromJsonFile(String id) throws IOException{
		StringBuilder val = new StringBuilder("");
		for(String i : id.split("-"))
			val.append(i);
		
		ObjectMapper obj = new ObjectMapper();
		
		return obj.readValue(new File(AppUtility.DIRECTORY_PATH+""+val+"/metadata.json"), MovieDetails.class);
	}	
}
