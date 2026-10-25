package com.eraykosterelioglu.start_spring_jpa.dto;

import com.eraykosterelioglu.start_spring_jpa.entites.Course;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DtoStudent {

    private String firstName;

    private String lastName;

    private List<DtoCourse> courses;
}
