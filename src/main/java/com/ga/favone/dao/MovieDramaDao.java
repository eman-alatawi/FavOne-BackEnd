package com.ga.favone.dao;

import org.springframework.data.repository.CrudRepository;

import com.ga.favone.model.MovieDrama;

public interface MovieDramaDao extends CrudRepository<MovieDrama, Integer>{
	public MovieDrama findById(int id);
}
