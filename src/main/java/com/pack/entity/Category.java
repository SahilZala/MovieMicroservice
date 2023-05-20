package com.pack.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Category {
	@Override
	public String toString() {
		return "Category [category=" + categoryName +"]";
	}

	

	public String getCategory() {
		return categoryName;
	}

	public void setCategory(String category) {
		this.categoryName = category;
	}

	
	@Id
	private String categoryName;
	
	
	public Category( String category) {
		super();
		this.categoryName = category;
	}

	public Category() {
		super();
	}
	
	
}
