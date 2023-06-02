package com.example.demo.controllers;

import com.example.demo.models.Publisher;
import com.example.demo.repositories.PublisherRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/publishers")
public class PublisherController {
    @Autowired
    private PublisherRepository publisherRepository;

    @GetMapping
    public List<Publisher> list(){
        return publisherRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{publisher_id}")
    public Publisher get (@PathVariable Long publisher_id){
        return publisherRepository.getOne(publisher_id);
    }

    @PostMapping
    public Publisher create(@RequestBody final Publisher publisher){


        return publisherRepository.saveAndFlush(publisher);


    }

    @RequestMapping(value = "{publisher_id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long publisher_id) {
        publisherRepository.deleteById(publisher_id);
    }

    @RequestMapping(value = "{publisher_id}", method = RequestMethod.PUT)
    public Publisher update(@PathVariable Long publisher_id, @RequestBody Publisher publisher){
        //PUT vs PATCH
        Publisher existingPublisher = publisherRepository.getOne(publisher_id);
        BeanUtils.copyProperties(publisher,existingPublisher, "publisher_id");
        return publisherRepository.saveAndFlush(existingPublisher);
    }

}


