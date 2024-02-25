package com.example.bookstore.controller;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.bookstore.domain.Book;
import com.example.bookstore.domain.BookRepo;

@Controller
public class BookController {

    private final BookRepo bookRepo;

    public BookController(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    @GetMapping("/booklist")
    public String showBookList(Model model) {
        Iterable<Book> books = bookRepo.findAll(); // Fetch all books from the database
        model.addAttribute("books", books); // Add books to the model
        return "booklist"; // Return the name of the Thymeleaf template
    }
    }
