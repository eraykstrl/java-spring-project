package com.eraykosterelioglu.start_spring_jpa.services;

import com.eraykosterelioglu.start_spring_jpa.dto.DtoEmployee;
import com.eraykosterelioglu.start_spring_jpa.dto.DtoEmployeeIU;

import java.util.List;

public interface IEmployeeService {

    public List<DtoEmployee> listEmployee();

    public DtoEmployee save(DtoEmployeeIU dtoEmployeeUI);
}
