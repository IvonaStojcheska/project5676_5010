package com.example.demo.controllers;

import com.example.demo.models.Book;
import com.example.demo.repositories.BookRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/books")
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    @GetMapping
    public List<Book> list(){
        return bookRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{book_id}")
    public Book get (@PathVariable Long book_id){
        return bookRepository.getOne(book_id);
    }

    @PostMapping
    public Book create(@RequestBody final Book book){


        return bookRepository.saveAndFlush(book);


    }

    @RequestMapping(value = "{book_id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long book_id) {
        bookRepository.deleteById(book_id);
    }

    @RequestMapping(value = "{book_id}", method = RequestMethod.PUT)
    public Book update(@PathVariable Long book_id, @RequestBody Book book){
        //PUT vs PATCH
        Book existingBook = bookRepository.getOne(book_id);
        BeanUtils.copyProperties(book,existingBook, "book_id");
        return bookRepository.saveAndFlush(existingBook);
    }

}


