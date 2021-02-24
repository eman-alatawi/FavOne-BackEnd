package com.ga.favone.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ga.favone.dao.ImageGalleryDao;
import com.ga.favone.model.ImageGallery;

@RestController
public class ImageGalleryController {
	
	@Autowired
	private ImageGalleryDao dao;

	@GetMapping("/imagegallery/index")
	public Iterable<ImageGallery> getImageGallery(){
		var it = dao.findAll();
		return it;
	}
	
	@GetMapping("/imagegallery/detail")
	public ImageGallery imagegalleryDetails(@RequestParam int id) {
		ImageGallery imagegallery = dao.findById(id);
		return imagegallery;
	}
	
	@PostMapping("/imagegallery/add")
	public ImageGallery addImageGallery(@RequestBody ImageGallery imagegallery) {
		dao.save(imagegallery);
		return imagegallery;
	}
	
	@PutMapping("/imagegallery/edit")
	public ImageGallery editImageGallery(@RequestBody ImageGallery imagegallery) {
		dao.save(imagegallery);
		return imagegallery;
	}
	
	@DeleteMapping("/imagegallery/delete")
	public boolean deleteImageGallery(@RequestParam int id) {
		dao.deleteById(id);
		return true;
	}
}
