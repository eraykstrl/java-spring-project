package com.eraykosterelioglu.start_spring_jpa.services;

import com.eraykosterelioglu.start_spring_jpa.dto.DtoEmployee;

import java.util.List;

public interface IEmployeeService {

    public List<DtoEmployee> listEmployee();
    
}
