package com.kevosolulu.employeemanagement.repositories;

import com.kevosolulu.employeemanagement.entity.Department;
import com.kevosolulu.employeemanagement.entity.Office;
import com.kevosolulu.employeemanagement.entity.Users;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
class DepartmentRepositoryTest {
    @Autowired
    private DepartmentRepository departmentRepository;
    @Test
    public void printDepartments() {
        List<Department> departmentList = departmentRepository.findAll();
        System.out.println("departments: " + departmentList);
    }
    @Test
    public void saveDepartment(){
//        Users userFirst = Users.builder()
//                .email("random.me@meme.com")
//                .password("hello-there")
//                .username("random")
//                .build();
//        Users userSecond = Users.builder()
//                .email("random.you@meme.com")
//                .password("hello-there")
//                .username("randomYou")
//                .build();
        Office office = Office.builder()
                .name("MainHall")
                .build();

        Department department =
                Department.builder()
                        .name("TSM")
                        .created_by("Me")
                        .created_at(new Date())
                        .code("GGs")
                        .office(office)
                        .build();
        departmentRepository.save(department);
    }
}