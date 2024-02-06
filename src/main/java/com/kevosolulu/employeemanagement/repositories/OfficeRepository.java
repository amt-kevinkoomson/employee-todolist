package com.kevosolulu.employeemanagement.repositories;

import com.kevosolulu.employeemanagement.entity.Office;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfficeRepository extends JpaRepository<Office, Integer> {

}
