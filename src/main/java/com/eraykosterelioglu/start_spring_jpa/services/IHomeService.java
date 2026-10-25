package com.eraykosterelioglu.start_spring_jpa.services;

import com.eraykosterelioglu.start_spring_jpa.dto.DtoHome;
import org.springframework.stereotype.Service;

public interface IHomeService {

    public DtoHome findHomeById(Long id);
}
