package com.eraykosterelioglu.start_spring_jpa.services;

import com.eraykosterelioglu.start_spring_jpa.dto.DtoCustomer;
import org.springframework.stereotype.Service;

public interface ICustomerService {

    public DtoCustomer findCustomerById(Long id);
}