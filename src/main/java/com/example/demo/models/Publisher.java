package com.example.demo.models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) private Long publisher_id;
    private String name;
    private Long author_id;
    private Long book_id;

    public Publisher() {
    }

    public Long getPublisher_id() {
        return publisher_id;
    }

    public void setPublisher_id(Long publisher_id) {
        this.publisher_id = publisher_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(Long author_id) {
        this.author_id = author_id;
    }

    public Long getBook_id() {
        return book_id;
    }

    public void setBook_id(Long book_id) {
        this.book_id = book_id;
    }
}
