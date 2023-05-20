package com.pack.entity;

import java.util.List;

public class MovieDetails {
	
	@Override
	public String toString() {
		return "MovieDetails [id=" + id + ", name=" + name + ", details=" + details + ", movieFileName=" + movieFileName
				+ ", imdbRating=" + imdbRating + ", landscapPoster=" + landscapPoster + ", portraitPoster="
				+ portraitPoster + ", category=" + category + ", activation=" + activation + "]";
	}
	public List<Category> getCategory() {
		return category;
	}
	public void setCategory(List<Category> category) {
		this.category = category;
	}
	private String id;
	private String name;
	private String details;
	private String movieFileName;
	private float imdbRating;
	private List<String> landscapPoster;
	private List<String> portraitPoster;
	
	private List<Category> category;
	
	private Boolean activation;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public String getMovieFileName() {
		return movieFileName;
	}
	public void setMovieFileName(String movieFileName) {
		this.movieFileName = movieFileName;
	}
	public float getImdbRating() {
		return imdbRating;
	}
	public void setImdbRating(float imdbRating) {
		this.imdbRating = imdbRating;
	}
	public List<String> getLandscapPoster() {
		return landscapPoster;
	}
	public void setLandscapPoster(List<String> landscapPoster) {
		this.landscapPoster = landscapPoster;
	}
	public List<String> getPortraitPoster() {
		return portraitPoster;
	}
	public void setPortraitPoster(List<String> portraitPoster) {
		this.portraitPoster = portraitPoster;
	}
	public Boolean getActivation() {
		return activation;
	}
	public void setActivation(Boolean activation) {
		this.activation = activation;
	}
	
	
	public MovieDetails(String id, String name, String details, String movieFileName, int imdbRating,
			List<String> landscapPoster, List<String> portraitPoster, List<Category> category, Boolean activation) {
		super();
		this.id = id;
		this.name = name;
		this.details = details;
		this.movieFileName = movieFileName;
		this.imdbRating = imdbRating;
		this.landscapPoster = landscapPoster;
		this.portraitPoster = portraitPoster;
		this.category = category;
		this.activation = activation;
	}
	public MovieDetails() {
		super();
	}
	
	
}
