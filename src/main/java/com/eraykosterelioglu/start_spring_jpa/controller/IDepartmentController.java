package com.eraykosterelioglu.start_spring_jpa.controller;

import com.eraykosterelioglu.start_spring_jpa.dto.DtoDepartment;
import com.eraykosterelioglu.start_spring_jpa.dto.DtoDepartmentIU;

import java.util.List;

public interface IDepartmentController {

    public List<DtoDepartment> listDepartment();

    public DtoDepartment saveDepartment(DtoDepartmentIU departmentIU);
}
