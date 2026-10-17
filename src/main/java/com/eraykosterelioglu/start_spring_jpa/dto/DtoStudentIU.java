package com.eraykosterelioglu.start_spring_jpa.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DtoStudentIU {

    @NotEmpty(message = "Name value can not be empty or null")
    @Min(value = 3)
    @Max(value = 3)
    private String firstName;

    @Size(min = 3,max = 10)
    private String lastName;

    private LocalDate dateOfBirth;
}
