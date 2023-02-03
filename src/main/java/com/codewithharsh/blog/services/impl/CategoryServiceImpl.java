package com.codewithharsh.blog.services.impl;

import java.util.ArrayList;
import java.util.List;

import java.util.Locale.Category;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codewithharsh.blog.payloads.CategoryDto;
import com.codewithharsh.blog.entities.Cateogory;
import com.codewithharsh.blog.exceptions.ResourceNotFoundException;

import com.codewithharsh.blog.repositories.CategoryRepo;
import com.codewithharsh.blog.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
		
	@Override
	public CategoryDto createCategory(CategoryDto categroyDto) {
		Cateogory cat =	this.modelMapper.map(categroyDto, Cateogory.class);
		Cateogory addedCat =  this.categoryRepo.save(cat);
		return this.modelMapper.map(addedCat, CategoryDto.class);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categroyDto, Integer categoryId) {
		
		Cateogory cat = this.categoryRepo.findById(categoryId)
.orElseThrow(()-> new ResourceNotFoundException("Cateogry","Cateogory Id",categoryId));
		
		cat.setCategoryTitle(categroyDto.getCategoryTitle());
		cat.setCategoryDescription(categroyDto.getCategoryDescription());
		Cateogory updatecat = this.categoryRepo.save(cat);
		
		return this.modelMapper.map(updatecat, CategoryDto.class);
	}

	@Override
	public void deleteCategory(Integer categoryId) {
		Cateogory cat = this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Cateogory","CateogoryId",categoryId));
		this.categoryRepo.delete(cat);

	}


	@Override
	public CategoryDto getCategory(Integer categoryId) {
			Cateogory cat  = this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Cateogory","Cateogory Id",categoryId ));
			return this.modelMapper.map(cat, CategoryDto.class);
	}

		
	@Override
	public List<CategoryDto> getCategories()
	{
		List<Cateogory> cateogory =  this.categoryRepo.findAll();
		System.out.println(cateogory);
		List<CategoryDto> ncatList = new ArrayList<>();
		cateogory.forEach(cat ->{
			CategoryDto dto = new CategoryDto();
			dto.setCategoryDescription(cat.getCategoryDescription());
			dto.setCategoryId(cat.getCategoryId());
			dto.setCategoryTitle(cat.getCategoryTitle());
			ncatList.add(dto);
		});
		//List<CategoryDto> catDtos  =	cateogory.stream().map((cat)->this.modelMapper.map(cateogory, CategoryDto.class)).collect(Collectors.toList());
		System.out.println(ncatList);
		
		return ncatList;
	}
}
