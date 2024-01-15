package com.kevosolulu.employeemanagement.authentication;

import com.kevosolulu.employeemanagement.model.User;
import com.kevosolulu.employeemanagement.repository.UserCollectionRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {
    private final UserCollectionRepository repository;

    public AuthenticationController(UserCollectionRepository repository) {
        this.repository = repository;
    }
    @GetMapping("/all-users")
    public List<User> findAll() {
        return repository.findAll();
    }
    @GetMapping("/user/{id}")
    public User findById(@PathVariable Integer id) {
        return repository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not Found boy!"));
    }
    @PostMapping("/create-user")
    public void createUser(@RequestBody User user) {
        System.out.println("Hello ****************");
        repository.save(user);
    }

}

