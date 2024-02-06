package com.kevosolulu.employeemanagement.repositories;

import com.kevosolulu.employeemanagement.entity.Department;
import com.kevosolulu.employeemanagement.entity.Office;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class OfficeRepositoryTest {
    @Autowired
    private OfficeRepository officeRepository;
    @Test
    public void saveOffice() {
        Department department = Department.builder()
                .code("TfSM")
                .created_at(new Date(2024))
                .name("Professionals")
                .build();

        Office office = Office.builder()
                .name("Berlins")
                .department(department)
                .build();
        officeRepository.save(office);
    }
    @Test
    public void printAllOffices() {
        List<Office> offices = officeRepository.findAll();
        System.out.println("offices: " + offices);
    }

}