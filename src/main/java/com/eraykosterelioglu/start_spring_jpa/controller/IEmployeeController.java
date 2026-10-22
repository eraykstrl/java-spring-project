package com.eraykosterelioglu.start_spring_jpa.controller;


import com.eraykosterelioglu.start_spring_jpa.dto.DtoEmployee;
import com.eraykosterelioglu.start_spring_jpa.dto.DtoEmployeeUI;

import java.util.List;

public interface IEmployeeController {

    public List<DtoEmployee> listEmployee();

    public DtoEmployee saveEmployee(DtoEmployeeUI dtoEmployeeUI);
}
