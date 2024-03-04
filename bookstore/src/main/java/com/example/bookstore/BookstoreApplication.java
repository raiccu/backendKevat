package com.example.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.bookstore.domain.Book;
import com.example.bookstore.domain.BookRepo;
import com.example.bookstore.domain.Category;
import com.example.bookstore.domain.CategoryRepo;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner BookCommandLineRunner(BookRepo bookRepo, CategoryRepo categoryRepo) {
		return (args) -> {
			Category category1 = new Category("Scifi");
			categoryRepo.save(category1);
			Category category2 = new Category("Fantasy");
			categoryRepo.save(category2);
			Category category3 = new Category("Comic");
			categoryRepo.save(category3);

			Book a = new Book("How Java and suicide rates are linked", "Jarkko", 2024, 123124, 66, category2);
			Book b = new Book("Roopen kokkikirja", "Roope", 2023, 123123, 69, category3);

			bookRepo.save(b);
			bookRepo.save(a);

		};
	}

}
