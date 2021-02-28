package com.ga.favone.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ga.favone.dao.GenderDao;
import com.ga.favone.model.Gender;

@RestController
public class GenderController {
	
	@Autowired
	private GenderDao dao;

	@GetMapping("/mdgender/index")
	public Iterable<Gender> getGender(){
		var it = dao.findAll();
		return it;
	}
	
	
	@PostMapping("/mdgender/add")
	public Gender addGender(@RequestBody Gender mdgender) {
		dao.save(mdgender);
		return mdgender;
	}
	
	@PutMapping("/mdgender/edit")
	public Gender editGender(@RequestBody Gender mdgender) {
		dao.save(mdgender);
		return mdgender;
	}
	
	@DeleteMapping("/mdgender/delete")
	public boolean deleteGender(@RequestParam int id) {
		dao.deleteById(id);
		return true;
	}
}
