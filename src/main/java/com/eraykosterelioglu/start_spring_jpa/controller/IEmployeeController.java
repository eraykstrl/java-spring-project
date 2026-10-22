package com.eraykosterelioglu.start_spring_jpa.controller;


import com.eraykosterelioglu.start_spring_jpa.dto.DtoEmployee;

import java.util.List;

public interface IEmployeeController {

    public List<DtoEmployee> listEmployee();
}
