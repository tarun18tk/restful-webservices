package com.springboot.rest.webservices.restfulwebservices.user;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
public class UserResource {

    private UserDaoService service;

    public UserResource(UserDaoService service) {
        this.service = service;
    }

    // @GetMapping("/users")
    // public List<User> findAllUsers() {
    // return service.findAll();
    // }

    // The response that we are sending must contain the status of what this api is
    // doing.
    // The returned object must be inside ResponseEntity<> and HttpStatus must be
    // set.

    @GetMapping("/users")
    public ResponseEntity<List<User>> findAllUsers() {
        List<User> users = service.findAll();
        if (users.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> findUser(@PathVariable int id) {
        User user = service.findUserById(id);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user, HttpStatus.FOUND);
    }

    @PostMapping("/users")
    public User creatUser(@Valid @RequestParam(name = "name") String name, @RequestParam(name = "year") int year) {
        User user = new User(4, name, LocalDate.now().minusYears(year));
        service.addUser(user);
        return user;

    }

    @GetMapping("user-delete/{id}")
    public User deleteUser(@PathVariable int id) {
        return service.deleteUserById(id);
    }
}

/*
 * Swagger and Open API
 * These are the tools to craete documentation from code instead of manual
 * documentation
 * Swagger specification became Open API specification
 * Swagger UI: visualize and interact with REST API.
 * for swagger ui use the config used here with Version 2.2.0
 * this is for visualisation of status and other properties of our API
 * 
 * 
 */