package com.eraykosterelioglu.start_spring_jpa.controller.impl;

import com.eraykosterelioglu.start_spring_jpa.controller.IStudentController;
import com.eraykosterelioglu.start_spring_jpa.dto.DtoStudent;
import com.eraykosterelioglu.start_spring_jpa.dto.DtoStudentIU;
import com.eraykosterelioglu.start_spring_jpa.entites.Student;
import com.eraykosterelioglu.start_spring_jpa.services.IStudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/api/student")
public class StudentControllerImpl implements IStudentController {

    @Autowired
    private IStudentService studentService;

    @PostMapping("/save")
    @Override
    public DtoStudent saveStudent(@RequestBody @Valid DtoStudentIU student) {

        return studentService.saveStudent(student);
    }

    @GetMapping("/list")
    @Override
    public List<DtoStudent> getAllStudent() {
        return studentService.getAllStudent();
    }

    @GetMapping("/{id}")
    @Override
    public DtoStudent getStudentById(
            @PathVariable Integer id
    ) {
        return studentService.getStudentById(id);
    }

    @DeleteMapping("/delete/{id}")
    @Override
    public void deleteStudent(@PathVariable(name = "id") Integer id) {
        studentService.deleteStudent(id);
    }

    @PutMapping("/update/{id}")
    @Override
    public DtoStudent updateStudent(
            @PathVariable(name = "id") Integer id,
            @RequestBody DtoStudentIU updatedStudent
    ) {
        return studentService.updateStudent(id,updatedStudent);
    }

}
