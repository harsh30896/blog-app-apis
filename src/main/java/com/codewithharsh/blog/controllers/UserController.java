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

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService  userService;
	
	
	// POST-CREATE USER
	@PostMapping("/")
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto)
	{
		 UserDto createUserDto  = this.userService.createUser(userDto);
		 return new ResponseEntity<>(createUserDto,HttpStatus.CREATED);
		
	}
	

	// PUT-UPDATE USER
	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto,@PathVariable ("userId") Integer uid) 
	{
		UserDto updatedUser = this.userService.updateUser(userDto, uid);
		return ResponseEntity.ok(updatedUser);
	}
	
	// DELETE-DELETE USER
//	@DeleteMapping("/{userId}")
//	public ResponseEntity<ApiResponse> deleteUser(@PathVariable("userId") Integer uid)
////	{
////		this.deleteUser(uid);
////		return new ResponseEntity (new ApiResponse("user deleted successfully",true), HttpStatus.OK);
//////	}
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<ApiResponse>  deleteUser(@PathVariable("userId") Integer uid)
	{
		ApiResponse response = new ApiResponse();
		try {
			userService.deleteUser(uid);
		}catch(Exception e) {
			response.setResponse("reason : ");
			response.setVal(false);
			//return false;
			return new ResponseEntity<ApiResponse> (response, HttpStatus.OK);
		}
		response.setResponse("success : ");
		response.setVal(true);
	//	return response;
		//response.("user deleted successfully",true)
		return new ResponseEntity<ApiResponse> (response, HttpStatus.OK);
		//return true;
	}
	
	
	// GET- ALL USER GET
	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAllUsers()
	{
		return ResponseEntity.ok(this.userService.getAllUsers());
	}

	// GET- Single
	// User GET
	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> getAllUsers(@PathVariable Integer userId)
	{
		return ResponseEntity.ok(this.userService.getUserById(userId));
	}
	

	
}