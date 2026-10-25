package com.eraykosterelioglu.start_spring_jpa.controller;

import com.eraykosterelioglu.start_spring_jpa.dto.DtoStudent;
import com.eraykosterelioglu.start_spring_jpa.dto.DtoStudentIU;
import com.eraykosterelioglu.start_spring_jpa.entites.Student;

import java.util.List;

public interface IStudentController {

    public DtoStudent saveStudent(DtoStudentIU student);

    public List<DtoStudent> getAllStudent();

    public DtoStudent getStudentById(Integer id);

    public void deleteStudent(Integer id);

    public DtoStudent updateStudent(Integer id,DtoStudentIU updatedStudent);

}
