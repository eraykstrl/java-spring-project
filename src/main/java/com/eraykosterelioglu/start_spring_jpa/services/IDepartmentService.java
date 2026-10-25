package com.eraykosterelioglu.start_spring_jpa.services;

import com.eraykosterelioglu.start_spring_jpa.dto.DtoDepartment;
import com.eraykosterelioglu.start_spring_jpa.dto.DtoDepartmentIU;

import java.util.List;

public interface IDepartmentService {

    public List<DtoDepartment> listDepartment();

    public DtoDepartment saveDepartment(DtoDepartmentIU dtoDepartmentIU);
}
