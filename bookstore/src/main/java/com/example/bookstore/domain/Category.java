package com.example.bookstore.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Category {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryid;

    private String name;

    
    public Category() {}

    public Category(Long categoryid, String name) {
        this.categoryid = categoryid;
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

    @Override
    public String toString() {
        return "Category [id=" + categoryid + ", name=" + name + "]";
    }
}
