package com.eraykosterelioglu.start_spring_jpa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoEmployeeIU {

    private String employeeName;

    private DtoDepartment dtoDepartment;
}
