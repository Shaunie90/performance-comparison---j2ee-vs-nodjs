package com.javahelps.restservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javahelps.restservice.entity.GetAllData;
import com.javahelps.restservice.repository.UserRepository;

import javassist.tools.web.BadHttpRequest;

@RestController
@RequestMapping(path = "/allData")
public class DataController {

    @Autowired
    private UserRepository repository;

    @GetMapping
    public Iterable<GetAllData> findAll() {
        return repository.findAll();
    }

    @GetMapping(path = "/{username}")
    public GetAllData find(@PathVariable("username") String username) {
        return repository.findOne(username);
    }

    @PostMapping(consumes = "application/json")
    public GetAllData create(@RequestBody GetAllData user) {
        return repository.save(user);
    }

    @DeleteMapping(path = "/{username}")
    public void delete(@PathVariable("username") String username) {
        repository.delete(username);
    }

    @PutMapping(path = "/{url}")
    public GetAllData update(@PathVariable("url") String url, @RequestBody GetAllData user) throws BadHttpRequest {
        if (repository.exists(url)) {
            user.setUrl(url);
            return repository.save(user);
        } else {
            throw new BadHttpRequest();
        }
    }
}