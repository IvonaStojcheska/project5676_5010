package com.example.demo.controllers;

import com.example.demo.models.Author;
import com.example.demo.repositories.AuthorRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/authors")
public class AuthorController {
    @Autowired
    private AuthorRepository authorRepository;

    @GetMapping
    public List<Author> list(){
        return authorRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{author_id}")
    public Author get (@PathVariable Long author_id){
        return authorRepository.getOne(author_id);
    }

    @PostMapping
    public Author create(@RequestBody final Author author){


        return authorRepository.saveAndFlush(author);


    }

    @RequestMapping(value = "{author_id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long author_id) {
        authorRepository.deleteById(author_id);
    }

    @RequestMapping(value = "{author_id}", method = RequestMethod.PUT)
    public Author update(@PathVariable Long author_id, @RequestBody Author author){
        //PUT vs PATCH
        Author existingAuthor = authorRepository.getOne(author_id);
        BeanUtils.copyProperties(author,existingAuthor, "author_id");
        return authorRepository.saveAndFlush(existingAuthor);
    }

}