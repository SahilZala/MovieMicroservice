package com.pack.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pack.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, String>{
	
}
