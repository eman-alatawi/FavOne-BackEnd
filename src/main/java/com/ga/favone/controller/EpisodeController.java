package com.ga.favone.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ga.favone.dao.EpisodeDao;
import com.ga.favone.model.Episode;

@RestController
public class EpisodeController {
	
	@Autowired
	private EpisodeDao dao;

	@GetMapping("/episode/index")
	public Iterable<Episode> getEpisode(){
		var it = dao.findAll();
		return it;
	}
	
	@GetMapping("/episode/detail")
	public Episode episodeDetails(@RequestParam int id) {
		Episode episode = dao.findById(id);
		return episode;
	}
	
	@PostMapping("/episode/add")
	public Episode addEpisode(@RequestBody Episode episode) {
		dao.save(episode);
		return episode;
	}
	
	@PutMapping("/episode/edit")
	public Episode editEpisode(@RequestBody Episode episode) {
		dao.save(episode);
		return episode;
	}
	
	@DeleteMapping("/episode/delete")
	public boolean deleteEpisode(@RequestParam int id) {
		dao.deleteById(id);
		return true;
	}
}
