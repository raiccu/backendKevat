package com.example.bookstore.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.bookstore.domain.Book;
import com.example.bookstore.domain.BookRepo;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;

@CrossOrigin
@Controller
public class BookRestController {

    @Autowired
    private BookRepo bookRepo;

    @RequestMapping(value="/books", method = RequestMethod.GET)
    public @ResponseBody List<Book> getBooksRest() {
        return (List<Book>) bookRepo.findAll();
    }

    @RequestMapping(value="/books/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Book> getBookByIdRest(@PathVariable("id") Long id) {
        return bookRepo.findById(id);
    }
}