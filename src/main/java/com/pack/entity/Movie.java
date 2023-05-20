package com.pack.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Movie {
	
	
	@Id
	String id;
	@OneToMany(mappedBy="categoryName")
	List<Category> category;
	
	boolean activation;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public boolean isActivation() {
		return activation;
	}
	public void setActivation(boolean activation) {
		this.activation = activation;
	}
	public List<Category> getCategory() {
		return category;
	}
	public void setCategory(List<Category> category) {
		this.category = category;
	}
	
	
	public Movie(String id, List<Category> category, boolean activation) {
		super();
		this.id = id;
		this.category = category;
		this.activation = activation;
	}
	public Movie() {
		super();
	}
}
