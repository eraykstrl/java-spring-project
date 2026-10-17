package com.eraykosterelioglu.start_spring_jpa.services.impl;

import com.eraykosterelioglu.start_spring_jpa.dto.DtoStudent;
import com.eraykosterelioglu.start_spring_jpa.dto.DtoStudentIU;
import com.eraykosterelioglu.start_spring_jpa.entites.Student;
import com.eraykosterelioglu.start_spring_jpa.repository.StudentRepository;
import com.eraykosterelioglu.start_spring_jpa.services.IStudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public DtoStudent saveStudent(DtoStudentIU dtoStudentIU) {
        Student student = new Student();
        BeanUtils.copyProperties(dtoStudentIU,student);

        Student dbStudent = studentRepository.save(student);
        DtoStudent response = new DtoStudent();
        BeanUtils.copyProperties(dbStudent,response);
        return response;
    }

    @Override
    public List<DtoStudent> getAllStudent() {
        List<Student> dbStudent = studentRepository.findAllStudent();
        List<DtoStudent> dtoStudentList = new ArrayList<>();
        for(Student student : dbStudent) {
            DtoStudent dtoStudent = new DtoStudent();
            BeanUtils.copyProperties(student,dtoStudent);
            dtoStudentList.add(dtoStudent);
        }
        return dtoStudentList;
    }

    @Override
    public DtoStudent getStudentById(Integer id) {
        Optional<Student> optional = studentRepository.findStudentById(id);
        if(optional.isPresent()) {
            DtoStudent dtoStudent = new DtoStudent();
            BeanUtils.copyProperties(optional.get(),dtoStudent);
            return dtoStudent;
        }
        return null;
    }

    @Override
    public void deleteStudent(Integer id) {
        Optional<Student> optional = studentRepository.findById(id);
        if(optional.isPresent()) {
            studentRepository.delete(optional.get());
        }
    }

    @Override
    public DtoStudent updateStudent(Integer id,DtoStudentIU dtoStudentIU) {
        Optional<Student> optional = studentRepository.findById(id);
        if(optional.isPresent()) {
            Student dbStudent = optional.get();
            dbStudent.setFirstName(dtoStudentIU.getFirstName());
            dbStudent.setLastName(dtoStudentIU.getLastName());
            dbStudent.setDateOfBirth(dtoStudentIU.getDateOfBirth());

            Student updatedStudent = studentRepository.save(dbStudent);
            DtoStudent dtoStudent = new DtoStudent();
            BeanUtils.copyProperties(updatedStudent,dbStudent);
            return dtoStudent;
        }
        return null;
    }
}
