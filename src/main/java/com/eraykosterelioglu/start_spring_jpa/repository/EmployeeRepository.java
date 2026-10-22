package com.eraykosterelioglu.start_spring_jpa.repository;

import com.eraykosterelioglu.start_spring_jpa.entites.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {


}
