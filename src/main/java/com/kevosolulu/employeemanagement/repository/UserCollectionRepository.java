package com.kevosolulu.employeemanagement.repository;

import com.kevosolulu.employeemanagement.model.Role;
import com.kevosolulu.employeemanagement.model.User;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;


@Repository
public class UserCollectionRepository {
    private final List<User> users = new ArrayList<>();
    public UserCollectionRepository(){}
    public List<User> findAll(){
        return users;
    }
    public Optional<User> findById(Integer id) {
        return users.stream().filter(c -> c.id().equals(id)).findFirst();
    }

    @PostConstruct
    private void init() {
        User user = new User(1, "admin", "admin@adm.com", "Admin@123", Role.ADMIN, LocalDateTime.now(), LocalDateTime.now());
        users.add(user);
    }
    public void save(User user) {
        users.removeIf(c->c.id().equals(user.id()));
        users.add(user);
    }
    public boolean existsById(Integer id) {
        return users.stream().anyMatch(c -> c.id().equals(id));
    }
    public void delete (Integer id) {
        if(users.stream().noneMatch(c->c.id().equals(id))) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        users.removeIf(c->c.id().equals(id));
    }

}
