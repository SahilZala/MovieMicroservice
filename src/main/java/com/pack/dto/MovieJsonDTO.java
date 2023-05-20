package com.pack.dto;

import java.io.IOException;

import com.pack.entity.MovieDetails;

public interface MovieJsonDTO {
	public void writeJsonFile(MovieDetails movieDetails) throws IOException;
	public void createMovieFolderandFile(String id);
	public MovieDetails fetchFromJsonFile(String id) throws IOException, NullPointerException;
}
