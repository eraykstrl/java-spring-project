package com.eraykosterelioglu.start_spring_jpa.services.impl;

import com.eraykosterelioglu.start_spring_jpa.dto.DtoEmployee;
import com.eraykosterelioglu.start_spring_jpa.entites.Employee;
import com.eraykosterelioglu.start_spring_jpa.repository.EmployeeRepository;
import com.eraykosterelioglu.start_spring_jpa.services.IEmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<DtoEmployee> listEmployee() {

        List<Employee> dbList = employeeRepository.findAll();

        if(dbList.isEmpty()) {
            return new ArrayList<>();
        }

        List<DtoEmployee> dtoEmployeeList = new ArrayList<>();
        for(Employee employee : dbList) {
            DtoEmployee dtoEmployee = new DtoEmployee();
            BeanUtils.copyProperties(employee,dtoEmployee);
            dtoEmployeeList.add(dtoEmployee);
        }
        return dtoEmployeeList;
    }
}
