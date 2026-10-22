package com.eraykosterelioglu.start_spring_jpa.controller;

import com.eraykosterelioglu.start_spring_jpa.dto.DtoHome;

public interface IHomeController {

    public DtoHome findHomeById(Long id);


}
