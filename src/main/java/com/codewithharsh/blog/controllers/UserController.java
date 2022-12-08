package com.codewithharsh.blog.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codewithharsh.blog.payloads.ApiResponse;
import com.codewithharsh.blog.payloads.UserDto;
import com.codewithharsh.blog.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService  userService;
	
	
	// POST-CREATE USER
	@PostMapping("/")
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto)
	{
		 UserDto createUserDto  = this.userService.createUser(userDto);
		 return new ResponseEntity<>(createUserDto,HttpStatus.CREATED);
		
	}
	
	// PUT-UPDATE USER
	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> updateUser (@RequestBody UserDto userDto,@PathVariable("userId") Integer userId)
	{
		UserDto updatedUser =  this.userService.updateUser(userDto, userId);
		return ResponseEntity.ok(updatedUser);
	}
	
	
	
	// DELETE-DELETE USER
		@DeleteMapping("/{userId}")
		public ResponseEntity<ApiResponse> deleteUser(@PathVariable("userId") Integer userId ){
			this.userService.deleteUser(userId);
			return new ResponseEntity(new ApiResponse("User Deleted Successfully",true) ,HttpStatus.OK);
		}
	 
	// GET- USER GET
	// Getting the information for all the users
	@GetMapping("/")
	public ResponseEntity<List <UserDto>> getAllUsers()
	{
		return ResponseEntity.ok(this.userService.getAllUsers());
	}
	
	// for getting the response for the single users
	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> getSingleUser(@PathVariable Integer userId)
	{
		return ResponseEntity.ok(this.userService.getUserById(userId));
	}
	

}
