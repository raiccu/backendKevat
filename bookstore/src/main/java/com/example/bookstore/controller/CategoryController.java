package com.example.bookstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.example.bookstore.domain.Category;
import com.example.bookstore.domain.CategoryRepo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class CategoryController {
    private final CategoryRepo categoryRepo;

    public CategoryController(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    @GetMapping("/categorylist")
    public String categoryListing(Model model) {
        Iterable<Category> categories = categoryRepo.findAll();
        model.addAttribute("categories", categories);

        return "categorylist";
    }
    
    @GetMapping("/addcategory")
    public String addCategoryForm(Model model) {
        model.addAttribute("category", new Category());

        return "addcategory";
    }
    
    @SuppressWarnings("null")
    @PostMapping("/addcategory")
    public String addCategory(@ModelAttribute Category newCategory) {
       categoryRepo.save(newCategory);
        
        return "redirect:/categorylist";
    }
    
}
