package com.ga.favone.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ga.favone.config.JwtUtil;
import com.ga.favone.dao.UserDao;
import com.ga.favone.model.JwtResponse;
import com.ga.favone.model.User;

@RestController
public class UserController {

	@Autowired
	private UserDao dao;

	@PostMapping("/user/registration")
	public HashMap<String, String> registration(@RequestBody User user) {


		HashMap<String, String> response = new HashMap<String, String>();

		// Check to user is already registered or not

		var it = dao.findAll();

		for (User dbUser : it) {
			if (dbUser.getEmailAddress().equals(user.getEmailAddress())) {


				response.put("message", "User already exists");
				return response;
			}
		}

		// Password Encryption
		BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();
		String newPassword = bCrypt.encode(user.getPassword());
		user.setPassword(newPassword);

		dao.save(user);

		response.put("message", "User registered successfully");
		return response;
	}
	
	
	@Autowired
	AuthenticationManager  authenticationManager;
	
	@Autowired
	JwtUtil jwtUtil;
	
	@Autowired
	UserDetailsService  userDetailsService;
	
	@PostMapping("/user/authenticate")
    public ResponseEntity<?> authenticate(@RequestBody User user){
		
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(user.getEmailAddress(), user.getPassword())
					);
			
		}
		catch(BadCredentialsException e) {
			String res = "Incorrect username or password";
			return ResponseEntity.ok(res);
			
		}
		
		//continue
		
		UserDetails userDetails = userDetailsService.loadUserByUsername(user.getEmailAddress());
		
		String jwtToken = jwtUtil.generateToken(userDetails);
		System.out.println(jwtToken);
		return ResponseEntity.ok(new JwtResponse(jwtToken));
	}
	
	@PutMapping("/user/changePassword")
	public HashMap<String, String> changePassword(@RequestBody User user) {
		
		HashMap<String, String> response = new HashMap<String, String>();

		User dbuser = dao.findById(user.getId());
		BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();
		String oldPass = user.getOldPassword();

		if (bCrypt.matches(oldPass, dbuser.getPassword())) {
			String newPassword = bCrypt.encode(user.getPassword());
			user.setPassword(newPassword);

			dao.save(user);
			response.put("message", "The password  has been changed successfully");
		}

		else {
			response.put("message", "The Old password that you provide dosen't match the old password in our records");

		}


		return response;
	}
}
