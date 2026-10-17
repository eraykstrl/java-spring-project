package com.eraykosterelioglu.start_spring_jpa.repository;

import com.eraykosterelioglu.start_spring_jpa.entites.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {


    @Query(value = "from Student",nativeQuery = false)
    List<Student> findAllStudent();

    @Query(value = "from Student s where s.id = :studentId",nativeQuery = false)
    Optional<Student> findStudentById(Integer studentId);
}
