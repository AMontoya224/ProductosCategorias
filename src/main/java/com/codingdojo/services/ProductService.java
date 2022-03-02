package com.codingdojo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.models.Product;
import com.codingdojo.repositories.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;
	
	public Product insertIntoProducts( Product newProduct ) {
		return productRepository.save( newProduct );
	}
	
	public Product selectFromProductsWhereId( long id ){
		List<Product> productList = productRepository.findById(id);
		if ( productList.isEmpty() ) {
			Product productEmpty = new Product();
			return productEmpty;
		}
		return productList.get(0);
	}
	

}
