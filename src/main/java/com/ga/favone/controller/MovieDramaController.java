package com.ga.favone.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ga.favone.dao.MovieDramaDao;
import com.ga.favone.model.MovieDrama;

@RestController
public class MovieDramaController {
	
	@Autowired
	private MovieDramaDao dao;

	@GetMapping("/md/index")
	public Iterable<MovieDrama> getMovieDrama(){
		var it = dao.findAll();
		return it;
	}
	
	@GetMapping("/md/detail")
	public MovieDrama mdDetails(@RequestParam int id) {
		MovieDrama md = dao.findById(id);
		return md;
	}
	
	@PostMapping("/md/add")
	public MovieDrama addMovieDrama(@RequestBody MovieDrama md) {
		dao.save(md);
		return md;
	}
	
	@PutMapping("/md/edit")
	public MovieDrama editMovieDrama(@RequestBody MovieDrama md) {
		dao.save(md);
		return md;
	}
	
	@DeleteMapping("/md/delete")
	public boolean deleteMovieDrama(@RequestParam int id) {
		dao.deleteById(id);
		return true;
	}
}
