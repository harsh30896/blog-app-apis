package com.codewithharsh.blog.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codewithharsh.blog.entities.User;
import com.codewithharsh.blog.exceptions.ResourceNotFoundException;
import com.codewithharsh.blog.payloads.UserDto;
import com.codewithharsh.blog.repositories.UserRepo;
import com.codewithharsh.blog.services.UserService;
import com.codewithharsh.blog.exceptions.*;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public UserDto createUser(UserDto userDto) {
		User user = this.dtoToUser(userDto);
		User savedUser = this.userRepo.save(user);
		return this.userToDTO(savedUser);
	}
	
	
	
	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {
		
		User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException ("User","id",userId));
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());
	
		User updatedUser = this.userRepo.save(user);
		UserDto userDto1 = this.userToDTO(updatedUser);
		return userDto1;
	}

	@Override
	public UserDto getUserById(Integer userId) {
		User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","Id",userId));
		return this.userToDTO(user);
	}

	@Override
	public List<UserDto> getAllUsers() {
	
		List <User> users = this.userRepo.findAll();
		List<UserDto> userDtos = users.stream().map(user-> this.userToDTO(user)).collect(Collectors.toList());
		return userDtos;
	}

	@Override
	public void deleteUser(Integer userId) {
	 User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","Id", userId));
	this.userRepo.delete(user);	
	}
	private User dtoToUser(UserDto userDto) {
		User user = this.modelMapper.map(userDto, User.class);
		
		
		// user.setId(userDto.getId());
		// user.setName(userDto.getName());
		// user.setEmail(userDto.getEmail());
		// user.setEmail(userDto.getEmail());
		// user.setAbout(userDto.getAbout());
		// user.setPassword(userDto.getPassword());
		
		return user;
	}
	public UserDto userToDTO(User user) {
		UserDto userDto = this.modelMapper.map(user, UserDto.class);
		
		// userDto.setId(user.getId());
		// userDto.setName(user.getName());
		// userDto.setEmail(user.getEmail());
		// userDto.setPassword(user.getPassword());
		// userDto.setAbout(user.getAbout());

		return userDto;
	}

}
