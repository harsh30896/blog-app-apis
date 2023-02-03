package com.codewithharsh.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithharsh.blog.entities.Cateogory;

public interface CategoryRepo extends JpaRepository<Cateogory, Integer>{

}
