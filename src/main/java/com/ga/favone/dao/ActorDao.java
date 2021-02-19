package com.ga.favone.dao;

import org.springframework.data.repository.CrudRepository;

import com.ga.favone.model.Actor;

public interface ActorDao extends CrudRepository<Actor, Integer>{
	public Actor findById(int id);
}
