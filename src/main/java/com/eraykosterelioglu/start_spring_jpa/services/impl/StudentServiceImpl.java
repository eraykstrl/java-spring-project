package com.eraykosterelioglu.start_spring_jpa.services.impl;

import com.eraykosterelioglu.start_spring_jpa.dto.DtoCourse;
import com.eraykosterelioglu.start_spring_jpa.dto.DtoStudent;
import com.eraykosterelioglu.start_spring_jpa.dto.DtoStudentIU;
import com.eraykosterelioglu.start_spring_jpa.entites.Course;
import com.eraykosterelioglu.start_spring_jpa.entites.Student;
import com.eraykosterelioglu.start_spring_jpa.repository.StudentRepository;
import com.eraykosterelioglu.start_spring_jpa.services.IStudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public DtoStudent saveStudent(DtoStudentIU dtoStudentIU) {
        Student student = new Student();
        BeanUtils.copyProperties(dtoStudentIU,student);

        List<Course> courses = new ArrayList<>();

        for(DtoCourse dtoCourse : dtoStudentIU.getCourses()) {

            System.out.println("DtoCourse" + dtoCourse);
            Course course = new Course();
            BeanUtils.copyProperties(dtoCourse,course);
            System.out.println("Entity" + course);
            courses.add(course);
        }

        student.setCourses(courses);
        Student dbStudent = studentRepository.save(student);
        DtoStudent response = new DtoStudent();
        BeanUtils.copyProperties(dbStudent,response);

        List<DtoCourse> responseCourses = new ArrayList<>();
        for(Course course : dbStudent.getCourses()) {
            DtoCourse dtoCourse = new DtoCourse();
            BeanUtils.copyProperties(course,dtoCourse);
            responseCourses.add(dtoCourse);
        }
        response.setCourses(responseCourses);
        return response;
    }

    @Override
    public List<DtoStudent> getAllStudent() {
        List<Student> dbStudent = studentRepository.findAllStudent();
        List<DtoStudent> dtoStudentList = new ArrayList<>();
        for(Student student : dbStudent) {
            DtoStudent dtoStudent = new DtoStudent();
            BeanUtils.copyProperties(student,dtoStudent);

            List<DtoCourse> dtoCourses = new ArrayList<>();
            for(Course course : student.getCourses()) {
                DtoCourse dtoCourse = new DtoCourse();
                BeanUtils.copyProperties(course,dtoCourse);
                dtoCourses.add(dtoCourse);
            }
            dtoStudent.setCourses(dtoCourses);
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
            log.info("Student değeri var");
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

            List<Course> courses = new ArrayList<>();
            BeanUtils.copyProperties(dtoStudentIU.getCourses(),courses);
            dbStudent.setCourses(courses);

            Student updatedStudent = studentRepository.save(dbStudent);
            DtoStudent dtoStudent = new DtoStudent();
            BeanUtils.copyProperties(updatedStudent,dbStudent);

            List<DtoCourse> dtoCourses = new ArrayList<>();
            BeanUtils.copyProperties(updatedStudent.getCourses(),dtoCourses);
            dtoStudent.setCourses(dtoCourses);
            return dtoStudent;
        }

        return null;
    }
}
