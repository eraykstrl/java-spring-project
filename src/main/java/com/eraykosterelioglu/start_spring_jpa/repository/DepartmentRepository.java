package com.eraykosterelioglu.start_spring_jpa.repository;

import com.eraykosterelioglu.start_spring_jpa.entites.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department,Long> {

}
