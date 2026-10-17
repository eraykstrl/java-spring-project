package com.eraykosterelioglu.start_spring_jpa.services.impl;

import com.eraykosterelioglu.start_spring_jpa.dto.DtoAddress;
import com.eraykosterelioglu.start_spring_jpa.dto.DtoCustomer;
import com.eraykosterelioglu.start_spring_jpa.entites.Address;
import com.eraykosterelioglu.start_spring_jpa.entites.Customer;
import com.eraykosterelioglu.start_spring_jpa.repository.CustomerRepository;
import com.eraykosterelioglu.start_spring_jpa.services.ICustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public DtoCustomer findCustomerById(Long id ){

        Optional<Customer> optional= customerRepository.findById(id);

        if(optional.isEmpty()) {
            return null;
        }

        DtoCustomer dtoCustomer = new DtoCustomer();
        Customer customer = optional.get();
        BeanUtils.copyProperties(customer,dtoCustomer);

        Address address = optional.get().getAddress();
        DtoAddress dtoAddress = new DtoAddress();

        BeanUtils.copyProperties(address,dtoAddress);
        dtoCustomer.setAddress(dtoAddress);

        return dtoCustomer;
    }
}
