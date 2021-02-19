package com.ga.favone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ga.favone.dao.ActorDao;
import com.ga.favone.model.Actor;

@RestController
public class ActorController {
	
	@Autowired
	private ActorDao dao;

	@GetMapping("/actor/index")
	public Iterable<Actor> getActor(){
		var it = dao.findAll();
		return it;
	}
	
	@GetMapping("/actor/detail")
	public Actor actorDetails(@RequestParam int id) {
		Actor actor = dao.findById(id);
		return actor;
	}
	
	@PostMapping("/actor/add")
	public Actor addActor(@RequestBody Actor actor) {
		dao.save(actor);
		return actor;
	}
	
	@PutMapping("/actor/edit")
	public Actor editActor(@RequestBody Actor actor) {
		dao.save(actor);
		return actor;
	}
	
	@DeleteMapping("/actor/delete")
	public boolean deleteActor(@RequestParam int id) {
		dao.deleteById(id);
		return true;
	}
}
