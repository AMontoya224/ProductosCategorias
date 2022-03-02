package com.codingdojo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.models.Category;
import com.codingdojo.repositories.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;
	
	public Category insertIntoCategories( Category newCategory ) {
		return categoryRepository.save( newCategory );
	}
	
	public List<Category> selectAllFromCategories(){
		List<Category> categoriesList = categoryRepository.findAll();
		if ( categoriesList.isEmpty() ) {
			Category categoryVacio = new Category("N/A", null, null, null);
			categoriesList.add(categoryVacio);
		}
		return categoriesList;
	}
	
	public Category selectFromCategoriesWhereId( long id ){
		List<Category> categoryList = categoryRepository.findById(id);
		if ( categoryList.isEmpty() ) {
			Category categoryEmpty = new Category();
			return categoryEmpty;
		}
		return categoryList.get(0);
	}
}
