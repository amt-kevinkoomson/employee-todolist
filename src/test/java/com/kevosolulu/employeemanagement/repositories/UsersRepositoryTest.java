package com.kevosolulu.employeemanagement.repositories;

import com.kevosolulu.employeemanagement.entity.Department;
import com.kevosolulu.employeemanagement.entity.Users;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;
import java.util.Optional;

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
//    @Test
//    public void saveUserWithDepartment() {
//        Department department = Department.builder()
//                .code("SS2")
//                .name("New Dept")
//                .created_by("Sky-man")
//                .build();
//        Users user = Users.builder()
//                .email("meow2@gmail.com")
//                .password("purr")
//                .username("nene-san")
//                .department(department)
//                .build();
//        usersRepository.save(user);
//    }

    @Test
    public void printAllUsers() {
        List<Users> usersList = usersRepository.findAll();
        System.out.println("users list = " + usersList);
    }
    @Test
    public void printUserByEmail() {
        List<Users> user = usersRepository.findByEmail("random.me@meme.com");
        System.out.println("user = " + user);
    }
    @Test
    public void printUserByEmailContaining() {
        List<Users> user = usersRepository.findByEmailContaining("meow");
        System.out.println("user = " + user);
    }
    @Test
    public void assignDepartmentToUser () {
        Optional<Users> user = usersRepository.findById(1);

    }
}
