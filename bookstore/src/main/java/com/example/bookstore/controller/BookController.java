package com.example.bookstore.controller;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.bookstore.domain.Book;
import com.example.bookstore.domain.BookRepo;

import io.micrometer.common.lang.NonNull;

@Controller
public class BookController {

    private final BookRepo bookRepo;

    public BookController(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    @GetMapping("/booklist")
    public String showBookList(Model model) {
        Iterable<Book> books = bookRepo.findAll();
        model.addAttribute("books", books);
        return "booklist";
    }

    @GetMapping("/addbook")
    public String showAddBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "addbook";
    }

    @SuppressWarnings("null")
    @PostMapping("/addbook")
    public String addBook(@ModelAttribute Book newBook) {
        bookRepo.save(newBook);
        return "redirect:/booklist";
    }

    @SuppressWarnings("null")
    @PostMapping("/deletebook/{id}")
    public String deleteBook(@PathVariable @NonNull Long id) {
        bookRepo.deleteById(id);
        return "redirect:/booklist";
    }
    
    }
