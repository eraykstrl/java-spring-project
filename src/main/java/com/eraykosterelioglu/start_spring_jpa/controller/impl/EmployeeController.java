package com.eraykosterelioglu.start_spring_jpa.controller.impl;

import com.eraykosterelioglu.start_spring_jpa.controller.IEmployeeController;
import com.eraykosterelioglu.start_spring_jpa.dto.DtoEmployee;
import com.eraykosterelioglu.start_spring_jpa.dto.DtoEmployeeIU;
import com.eraykosterelioglu.start_spring_jpa.services.IEmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/api/employee")
public class EmployeeController implements IEmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @Override
    @GetMapping("/list")
    public List<DtoEmployee> listEmployee() {
        return null;
    }

    @Override
    @PostMapping("/save")
    public DtoEmployee saveEmployee(
            @RequestBody @Valid DtoEmployeeIU dtoEmployeeUI
            ) {
        return employeeService.save(dtoEmployeeUI);
    }

}
