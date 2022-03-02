package com.codingdojo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.models.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
	@SuppressWarnings("unchecked")
	Category save( Category newCategory );
	
	List<Category> findAll();
	
	List<Category> findById( long id );
}
