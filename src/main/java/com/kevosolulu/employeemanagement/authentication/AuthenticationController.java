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
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create-user")
    @CrossOrigin
    public User createUser(@RequestBody User user) {
        if(repository.existsById(user.id())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User already exists!");
        }
        repository.save(user);
        return repository.findById(user.id()).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/update-user/{id}")
    public void updateUser(@RequestBody User user, @PathVariable Integer id) {
        if(!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User cannot be found!");
        }
        repository.save(user);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/delete-user/{id}")
    public void deleteUserById(@PathVariable Integer id) {
        repository.delete(id);
    }

}

