package com.example.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.UserRepository;
import com.example.model.LoginModel;
import com.example.model.UserModel;
import com.example.model.UserTempModel;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {
	
	@Autowired
	public UserRepository userRepo;
	
	@PostMapping("/login")
	public UserModel checkLogin(@RequestBody LoginModel tempUser) {
		
		Optional<UserModel> user = userRepo.findById(tempUser.getEmail());
		
		if(user.isPresent())
			if(user.get().getEmail().equals(tempUser.getEmail()) && user.get().getPassword().equals(tempUser.getPassword())) {
				return user.get();
			}
		return null;
	}
	
	@PostMapping("/signup")
	public UserModel addUser(@RequestBody UserTempModel tempUser) {
		UserModel user = new UserModel(tempUser.getEmail(), tempUser.getUsername(), tempUser.getMobileNumber(), tempUser.getRole(), tempUser.getPassword());
		return userRepo.save(user);
	}
	
	
}
