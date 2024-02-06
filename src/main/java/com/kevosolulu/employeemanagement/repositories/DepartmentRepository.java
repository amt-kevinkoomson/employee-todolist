package com.kevosolulu.employeemanagement.repositories;

import com.kevosolulu.employeemanagement.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository <Department, Integer> {

}
