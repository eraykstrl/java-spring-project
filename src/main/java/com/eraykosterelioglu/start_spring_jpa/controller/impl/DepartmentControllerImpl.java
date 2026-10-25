package com.eraykosterelioglu.start_spring_jpa.controller.impl;

import com.eraykosterelioglu.start_spring_jpa.controller.IDepartmentController;
import com.eraykosterelioglu.start_spring_jpa.dto.DtoDepartment;
import com.eraykosterelioglu.start_spring_jpa.dto.DtoDepartmentIU;
import com.eraykosterelioglu.start_spring_jpa.services.IDepartmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/api/department")
public class DepartmentControllerImpl implements IDepartmentController {

    @Autowired
    private IDepartmentService departmentService;

    @GetMapping("")
    public List<DtoDepartment> listDepartment(

            ) {

        return departmentService.listDepartment();
    }

    @PostMapping("/save")
    public DtoDepartment saveDepartment(
            @RequestBody
            @Valid DtoDepartmentIU departmentIU
    ) {
        return departmentService.saveDepartment(departmentIU);
    }
}
