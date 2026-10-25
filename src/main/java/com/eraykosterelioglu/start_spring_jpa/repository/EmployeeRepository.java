package com.eraykosterelioglu.start_spring_jpa.repository;

import com.eraykosterelioglu.start_spring_jpa.entites.Department;
import com.eraykosterelioglu.start_spring_jpa.entites.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

}
