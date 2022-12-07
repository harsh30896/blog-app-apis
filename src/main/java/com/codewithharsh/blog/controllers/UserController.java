package com.codewithharsh.blog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codewithharsh.blog.payloads.UserDto;
import com.codewithharsh.blog.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService  userService;
	
	
	// POST-CREATE USER
	@GetMapping("/")
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto)
	{
		 UserDto createUserDto  = this.userService.createUser(userDto);
		 return new ResponseEntity<>(createUserDto,HttpStatus.CREATED);
		
	}
	

	// PUT-UPDATE USER
	
	// DELETE-DELETE USER
	
	// GET- USER GET

}
