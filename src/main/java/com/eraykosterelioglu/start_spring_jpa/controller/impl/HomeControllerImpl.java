package com.eraykosterelioglu.start_spring_jpa.controller.impl;

import com.eraykosterelioglu.start_spring_jpa.controller.IHomeController;
import com.eraykosterelioglu.start_spring_jpa.dto.DtoHome;
import com.eraykosterelioglu.start_spring_jpa.services.IHomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/api/home")
public class HomeControllerImpl implements IHomeController {

    @Autowired
    private IHomeService homeService;

    @GetMapping("/list/{id}")
    public DtoHome findHomeById(
            @PathVariable("id") Long id
    ) {
        return homeService.findHomeById(id);
    }
}
