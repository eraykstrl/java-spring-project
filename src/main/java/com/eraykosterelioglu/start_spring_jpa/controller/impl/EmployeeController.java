package com.eraykosterelioglu.start_spring_jpa.controller.impl;

import com.eraykosterelioglu.start_spring_jpa.controller.IEmployeeController;
import com.eraykosterelioglu.start_spring_jpa.dto.DtoEmployee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/api/employee")
public class EmployeeController implements IEmployeeController {

    @Override
    @GetMapping("/list")
    public List<DtoEmployee> listEmployee() {
        return null;
    }

}
