package com.example.bookstore.domain;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Category {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "category_id")
    private Long categoryid;
    private String name;

    @OneToMany(mappedBy = "category")
    private List<Book> books;

    
    public Category() {}

    public Category(String name) {
        this.name = name;
    }

    public void setCategoryid(Long categoryid) {
        this.categoryid = categoryid;
    }
    public Long getCategoryid() {
        return categoryid;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public List<Book> getBooks(){
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
