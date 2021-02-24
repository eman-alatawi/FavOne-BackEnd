package com.ga.favone.dao;

import org.springframework.data.repository.CrudRepository;

import com.ga.favone.model.ImageGallery;

public interface ImageGalleryDao extends CrudRepository<ImageGallery, Integer>{
	public ImageGallery findById(int id);
}
