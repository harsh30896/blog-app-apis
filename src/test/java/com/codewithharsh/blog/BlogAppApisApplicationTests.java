package com.codewithharsh.blog;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.codewithharsh.blog.repositories.UserRepo;

@SpringBootTest
class BlogAppApisApplicationTests {

	@Autowired
	private UserRepo userRepo;
	
	@Test
	void contextLoads() {
	}

	@Test
	public void repoTest()
	{
		System.out.println("This is after the changes");s
        String className =	this.userRepo.getClass().getName();
        String pacKName = this.userRepo.getClass().getPackageName(); 
        System.out.println(className+" "+pacKName);
	}
	
}