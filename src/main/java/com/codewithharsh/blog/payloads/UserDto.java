package com.codewithharsh.blog.payloads;


import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter 
@Setter

public class UserDto {

	@NotEmpty
	private int id;
	
	@NotEmpty
	@Size(min  = 4, message = "Username must be of 4 characteres")
	private String name;
	
	@Email
	private String email;
	
	@NotEmpty
	private String password;
	
	@NotNull
	private String about;
	
}
