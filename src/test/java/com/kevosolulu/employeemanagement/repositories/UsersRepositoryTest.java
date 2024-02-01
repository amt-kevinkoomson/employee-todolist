package com.kevosolulu.employeemanagement.repositories;

import com.kevosolulu.employeemanagement.entity.Users;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
//@DataJpaTest
class UsersRepositoryTest {
    @Autowired
    private UsersRepository usersRepository;

    @Test
    public void saveUser() {
        Users user = Users.builder()
                .email("anay@gmail.com")
                .password("boomchakalaka")
                .username("boobayie")
                .build();
        usersRepository.save(user);
    }

    @Test
    public void printAllUsers() {
        List<Users> usersList = usersRepository.findAll();
        System.out.println("users list = " + usersList);
    }
    @Test
    public void printUserByEmail() {
        List<Users> user = usersRepository.findByEmail("anay@gmail.com");
        System.out.println("user = " + user);
    }
    @Test
    public void printUserByEmailContaining() {
        List<Users> user = usersRepository.findByEmailContaining("anay");
        System.out.println("user = " + user);
    }
    @Test
    public void printUserByUsernameNotNull() {
        List<Users> user = usersRepository.findByPasswordNotNull("boomchakalaka");
        System.out.println("user = " + user);
    }
}
