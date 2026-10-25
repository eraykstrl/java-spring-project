package com.eraykosterelioglu.start_spring_jpa.services.impl;

import com.eraykosterelioglu.start_spring_jpa.dto.DtoDepartment;
import com.eraykosterelioglu.start_spring_jpa.dto.DtoEmployee;
import com.eraykosterelioglu.start_spring_jpa.dto.DtoEmployeeIU;
import com.eraykosterelioglu.start_spring_jpa.entites.Department;
import com.eraykosterelioglu.start_spring_jpa.entites.Employee;
import com.eraykosterelioglu.start_spring_jpa.repository.DepartmentRepository;
import com.eraykosterelioglu.start_spring_jpa.repository.EmployeeRepository;
import com.eraykosterelioglu.start_spring_jpa.services.IEmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
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

            DtoDepartment dtoDepartment = new DtoDepartment();
            BeanUtils.copyProperties(employee.getDepartment(), dtoDepartment);

            dtoEmployee.setDtoDepartment(dtoDepartment);
            dtoEmployeeList.add(dtoEmployee);
        }
        return dtoEmployeeList;
    }

    @Override
    public DtoEmployee save(DtoEmployeeIU dtoEmployee) {


        Optional<Department> optionalDepartment = departmentRepository
                .findByDepartmentName(dtoEmployee.getDtoDepartment().getDepartmentName());

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

        DtoDepartment dtoDepartment = new DtoDepartment();
        BeanUtils.copyProperties(savedEmployee.getDepartment(),dtoDepartment);
        response.setDtoDepartment(dtoDepartment);
        return response;
    }
}
