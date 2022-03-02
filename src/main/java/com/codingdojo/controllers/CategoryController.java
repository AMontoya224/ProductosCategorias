package com.codingdojo.controllers;

import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.models.Category;
import com.codingdojo.services.CategoryService;

@Controller
@RequestMapping( "/categories" )
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	
	public Date date = new Date();
	
	@GetMapping( "/new" )
	public String newCategory( Model model ) {
		model.addAttribute("newCategory", new Category());
		return "newCategory.jsp";
	}
	
	@PostMapping( "/new" )
	public String newCategory_P( @Valid @ModelAttribute("newCategory") Category newCategory, 
            			    	BindingResult result, Model model, HttpSession session ) {
		if( result.hasErrors() ) {
			model.addAttribute("newCategory", new Category());
            return "newCategory.jsp";
		}
		newCategory.setCreatedAt(date);
		newCategory.setUpdatedAt(date);
		Category registeredCategory = categoryService.insertIntoCategories(newCategory);
		session.setAttribute( "category", registeredCategory.getName() );
		return "redirect:/categories/new";
	}
}
