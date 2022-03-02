package com.codingdojo.controllers;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.models.Category;
import com.codingdojo.models.Product;
import com.codingdojo.services.CategoryService;
import com.codingdojo.services.ProductService;

@Controller
@RequestMapping( "/products" )
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CategoryService categoryService;
	
	public Date date = new Date();
	
	@GetMapping( "/new" )
	public String newProduct( Model model ) {
		model.addAttribute("newProduct", new Product());
		return "newProduct.jsp";
	}
	
	@PostMapping( "/new" )
	public String newProduct_P( @Valid @ModelAttribute("newProduct") Product newProduct, 
            			    	BindingResult result, Model model, HttpSession session ) {
		if( result.hasErrors() ) {
			model.addAttribute("newProduct", new Product());
            return "newProduct.jsp";
		}
		newProduct.setCreatedAt(date);
		newProduct.setUpdatedAt(date);
		Product registeredProduct = productService.insertIntoProducts(newProduct);
		session.setAttribute( "product", registeredProduct.getName() );
		return String.format( "redirect:/products/%s", registeredProduct.getId() );
	}
	
	@GetMapping( "/{id}" )
	public String product( @PathVariable("id") long id, Model model, HttpSession session ) {
		//Product product = productService.selectFromProductsWhereId(id);
		//List<Category> categoriesListYes = productService.selectFromProductsYesContains(product);
		List<Category> categoriesList = categoryService.selectAllFromCategories();
		model.addAttribute("newProduct", new Product());
		model.addAttribute( "categoriesListYes", categoriesList );
		model.addAttribute( "categoriesListNot", categoriesList );
		model.addAttribute( "product", session.getAttribute("product") );
		return "products.jsp";
	}
	
	@PostMapping( "/add" )
	public String addProduct( @Valid @ModelAttribute("newProduct") Product newProduct, 
							  Model model, HttpSession session ) {
		Product registeredProduct = productService.insertIntoProducts(newProduct);
		return String.format( "redirect:/products/%s", registeredProduct.getId() );
	}
}
