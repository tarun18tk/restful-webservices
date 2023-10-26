package com.springboot.rest.webservices.restfulwebservices.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

    private static List<User> users = new ArrayList<>();

    static {
        users.add(new User(1, "Tarun", LocalDate.now().minusYears(30)));
        users.add(new User(2, "Singh", LocalDate.now().minusYears(10)));
        users.add(new User(3, "Karki", LocalDate.now().minusYears(21)));
    }

    public List<User> findAll() {
        return users;
    }

    public User findOne(int id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        return users.stream().filter(predicate).findFirst().get();
    }

    public User findUserById(int id) {
        for (User u : users) {
            if (u.getId() == id) {
                return u;
            }
        }
        return null;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public User deleteUserById(int id) {
        User del = findUserById(id);
        users.remove(del);
        return del;
    }
}
