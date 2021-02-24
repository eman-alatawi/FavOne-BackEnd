package com.ga.favone.dao;

import org.springframework.data.repository.CrudRepository;

import com.ga.favone.model.Episode;

public interface EpisodeDao extends CrudRepository<Episode, Integer>{
	public Episode findById(int id);
}
