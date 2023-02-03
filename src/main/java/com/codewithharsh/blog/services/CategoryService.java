package com.codewithharsh.blog.services;

import java.util.List;

import com.codewithharsh.blog.payloads.CategoryDto;

public interface CategoryService {

		// create
	
		public  CategoryDto	createCategory(CategoryDto categroyDto);
		
	
		// update
		
		public  CategoryDto	updateCategory(CategoryDto categroyDto, Integer categoryId);
		
		
		// delete
		
		public  void deleteCategory(Integer categoryId);
	
		// get
		
		public CategoryDto getCategory(Integer categoryId);
	
		// getAll
		List<CategoryDto> getCategories();
	
}
