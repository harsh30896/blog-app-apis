package com.codewithharsh.blog;


import java.lang.reflect.Method;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BlogAppApisApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(BlogAppApisApplication.class, args);
		System.out.println("Application Started");
		
		Class c = Class.forName("com.codewithharsh.blog.Test");
		Object obj = c.newInstance();
		Method method = c.getDeclaredMethod("m1", null);
	      method.setAccessible(true);
	      method.invoke(obj, null);
	}
	
	@Bean
	public ModelMapper modelMapper()
	{
		return new ModelMapper();
	}
}

class Test{
	private void m1() {
		System.out.println("private fun");
	}
}
