package com.codingdojo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.models.Category;
import com.codingdojo.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
	@SuppressWarnings("unchecked")
	Product save( Product newProduct );
	
	List<Product> findById( long id );
	
	//List<Category> findByProductsNotContains( Product newProduct );
	
	//List<Category> findByProductsYesContains( Product newProduct );
	
	//Product thisProduct = findProductById(productId);
	
	@Query( value = "SELECT * FROM categories" + 
			"JOIN categories_products ON categories_products.category_id = categories.id" + 
			"JOIN products ON products.id = categories_products.product_id" +
			"WHERE categories.id = ?1", nativeQuery = true )
	List<Category> selectFromProductsNotContains(Long id);

}
