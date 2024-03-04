package com.example.bookstore.controller;

import java.util.Optional;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.bookstore.domain.Book;
import com.example.bookstore.domain.BookRepo;
import com.example.bookstore.domain.CategoryRepo;

import io.micrometer.common.lang.NonNull;

@Controller
public class BookController {

    @Autowired
    private BookRepo bookRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    @GetMapping("/booklist")
    public String showBookList(Model model) {
        Iterable<Book> books = bookRepo.findAll();
        model.addAttribute("books", books);
        return "booklist";
    }

    @GetMapping("/addbook")
    public String showAddBookForm(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("categories", categoryRepo.findAll());
        return "addbook";
    }

    @SuppressWarnings("null")
    @PostMapping("/addbook")
    public String addBook(@ModelAttribute Book newBook) {
        bookRepo.save(newBook);
        return "redirect:/booklist";
    }

    @SuppressWarnings("null")
    @GetMapping("/deletebook/{id}")
    public String deleteBook(@PathVariable @NonNull Long id) {
        bookRepo.deleteById(id);
        return "redirect:/booklist";
    }

    @SuppressWarnings("null")
    @GetMapping("/editbook/{id}")
    public String editBook(@PathVariable Long id, Model model) {
       Optional<Book> optionalBook = bookRepo.findById(id);
        if (optionalBook.isPresent()) {
            model.addAttribute("book", optionalBook.get());
            model.addAttribute("categories", categoryRepo.findAll());
            return "editbook";
        } else {
            return "redirect:/booklist";
        }
    }
    
    @SuppressWarnings("null")
    @PostMapping("/updatebook")
    public String updateBook(@ModelAttribute Book updatedBook) {
        bookRepo.save(updatedBook);
        return "redirect:/booklist";
    }
    
    }
