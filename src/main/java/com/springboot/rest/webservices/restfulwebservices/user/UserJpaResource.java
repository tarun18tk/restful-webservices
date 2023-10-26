package com.springboot.rest.webservices.restfulwebservices.user;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.rest.webservices.restfulwebservices.jpa.UserRepository;

import jakarta.validation.Valid;

@RestController
public class UserJpaResource {

    // here we would use repository interface object
    // private UserDaoService service;
    private UserRepository service;

    public UserJpaResource(UserRepository service) {
        this.service = service;
    }

    @GetMapping("/jpa/users")
    public List<User> findAllUsers() {
        List<User> users = service.findAll();
        return users;
    }

    @GetMapping("/jpa/users/{id}")
    public Optional<User> findUser(@PathVariable int id) {
        Optional<User> user = service.findById(id);
        return user;
    }

    @PostMapping("/jpa/users")
    public User creatUser(@Valid @RequestParam(name = "name") String name,
            @RequestParam(name = "year") int year) {
        User user = new User(4, name, LocalDate.now().minusYears(year));
        service.save(user);
        return user;
    }

    @GetMapping("/jpa/user-delete/{id}")
    public void deleteUser(@PathVariable int id) {
        service.deleteById(id);
    }
}
