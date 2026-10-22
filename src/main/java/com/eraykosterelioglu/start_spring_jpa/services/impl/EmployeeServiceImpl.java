package com.eraykosterelioglu.start_spring_jpa.services.impl;

import com.eraykosterelioglu.start_spring_jpa.dto.DtoEmployee;
import com.eraykosterelioglu.start_spring_jpa.dto.DtoEmployeeUI;
import com.eraykosterelioglu.start_spring_jpa.entites.Department;
import com.eraykosterelioglu.start_spring_jpa.entites.Employee;
import com.eraykosterelioglu.start_spring_jpa.repository.DepartmentRepository;
import com.eraykosterelioglu.start_spring_jpa.repository.EmployeeRepository;
import com.eraykosterelioglu.start_spring_jpa.services.IEmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

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

    @Override
    public DtoEmployee save(DtoEmployeeUI dtoEmployee) {


        Optional<Department> optionalDepartment = departmentRepository
                .findDepartmentByName(dtoEmployee.getDtoDepartment().getDepartmentName());

        if(optionalDepartment.isEmpty()) {
            return null;
        }

        Department department = optionalDepartment.get();
        Employee employee = new Employee();
        BeanUtils.copyProperties(dtoEmployee,employee);
        employee.setDepartment(department);

        Employee savedEmployee = employeeRepository.save(employee);
        DtoEmployee response = new DtoEmployee();
        BeanUtils.copyProperties(savedEmployee,response);

        return response;
    }
}
