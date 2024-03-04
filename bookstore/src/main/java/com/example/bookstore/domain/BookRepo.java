package com.example.bookstore.domain;

import org.springframework.data.repository.CrudRepository;



public interface BookRepo extends CrudRepository<Book, Long> {

}
