package com.eraykosterelioglu.start_spring_jpa.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DtoStudentIU {

    @NotEmpty(message = "Name value can not be empty or null")
    @Size(min = 3,max = 10)
    private String firstName;

    @Size(min = 3,max = 10)
    private String lastName;

    @NotNull(message = "Date of birth can not be null")
    private LocalDate dateOfBirth;

    private List<DtoCourse> courses;
}
