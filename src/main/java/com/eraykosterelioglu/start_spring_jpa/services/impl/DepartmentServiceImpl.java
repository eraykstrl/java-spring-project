package com.eraykosterelioglu.start_spring_jpa.services.impl;

import com.eraykosterelioglu.start_spring_jpa.dto.DtoDepartment;
import com.eraykosterelioglu.start_spring_jpa.dto.DtoDepartmentIU;
import com.eraykosterelioglu.start_spring_jpa.entites.Department;
import com.eraykosterelioglu.start_spring_jpa.repository.DepartmentRepository;
import com.eraykosterelioglu.start_spring_jpa.services.IDepartmentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class DepartmentServiceImpl implements IDepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public List<DtoDepartment> listDepartment() {

        List<Department> dbDepartment = departmentRepository.findAll();

        if(dbDepartment.isEmpty()) {
            return null;
        }

        List<DtoDepartment> dtoDepartmentList = new ArrayList<>();

        for(Department department : dbDepartment) {
            DtoDepartment dtoDepartment = new DtoDepartment();
            BeanUtils.copyProperties(department,dtoDepartment);

            dtoDepartmentList.add(dtoDepartment);
        }

        return dtoDepartmentList;
    }

    public DtoDepartment saveDepartment(DtoDepartmentIU dtoDepartmentIU) {

        Department department = new Department();
        BeanUtils.copyProperties(dtoDepartmentIU,department);

        Department dbDepartment = departmentRepository.save(department);

        DtoDepartment dtoDepartment = new DtoDepartment();
        BeanUtils.copyProperties(dbDepartment,dtoDepartment);
        return dtoDepartment;
    }
}
