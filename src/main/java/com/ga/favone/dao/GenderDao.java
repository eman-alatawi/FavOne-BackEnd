package com.ga.favone.dao;

import org.springframework.data.repository.CrudRepository;

import com.ga.favone.model.Gender;

public interface GenderDao extends CrudRepository<Gender, Integer>{
	public Gender findById(int id);
}
