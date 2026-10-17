package com.eraykosterelioglu.start_spring_jpa.controller;

import com.eraykosterelioglu.start_spring_jpa.dto.DtoCustomer;

public interface ICustomerController {

    public DtoCustomer getCustomerById(Long id);
}
