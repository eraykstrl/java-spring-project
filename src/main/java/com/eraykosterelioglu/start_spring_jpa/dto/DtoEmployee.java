package com.eraykosterelioglu.start_spring_jpa.dto;

import com.eraykosterelioglu.start_spring_jpa.entites.Department;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoEmployee {

    private String employeeName;

    private DtoDepartment dtoDepartment;
}
