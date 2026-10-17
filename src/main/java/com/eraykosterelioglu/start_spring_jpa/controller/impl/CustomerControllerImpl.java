package com.eraykosterelioglu.start_spring_jpa.controller.impl;

import com.eraykosterelioglu.start_spring_jpa.controller.ICustomerController;
import com.eraykosterelioglu.start_spring_jpa.dto.DtoCustomer;
import com.eraykosterelioglu.start_spring_jpa.services.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/api/customer")
public class CustomerControllerImpl implements ICustomerController {

    @Autowired
    private ICustomerService customerService;

    @GetMapping("/list/{id}")
    @Override
    public DtoCustomer getCustomerById(@PathVariable(name = "id") Long id) {

        return  customerService.findCustomerById(id);
    }
}
