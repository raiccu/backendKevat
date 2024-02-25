package com.example.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.bookstore.domain.Book;
import com.example.bookstore.domain.BookRepo;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepo bookRepo) {
		return (args) -> {
			Book a  = new Book("Roopen kokkauskirja: hidden talent keep it hidden", "Roope", 2024, 112, 69);
			Book b  = new Book("How Java and Suicide rates are linked", "Joe Mama", 2023, 115, 69);

			bookRepo.save(a);
			bookRepo.save(b);
		};
	}

}
