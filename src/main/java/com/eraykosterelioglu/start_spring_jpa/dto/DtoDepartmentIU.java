package com.eraykosterelioglu.start_spring_jpa.dto;


import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoDepartmentIU {

    @Column(name = "department_name")
    private String departmentName;

}
