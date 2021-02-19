package com.ga.favone.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ga.favone.dao.UserDao;
import com.ga.favone.model.User;

@RestController
public class UserController {

	@Autowired
	private UserDao dao;

	@PostMapping("/user/join")
	public HashMap<String, String> join(@RequestBody User user) {

		HashMap<String, String> response = new HashMap<String, String>();

		var it = dao.findAll();

		for (User dbUser : it) {
			if (dbUser.getEmailAddress().equals(user.getEmailAddress()))
				response.put("message", "User already Exists");
			return response;
		}

		// Password Encryption
		BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();
		String newPassword = bCrypt.encode(user.getPassword());
		user.setPassword(newPassword);

		dao.save(user);
		response.put("message", "User registered successfully");
		return response;
	}
}
