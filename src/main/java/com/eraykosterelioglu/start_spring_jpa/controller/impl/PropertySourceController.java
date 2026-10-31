package com.eraykosterelioglu.start_spring_jpa.controller.impl;

import com.eraykosterelioglu.start_spring_jpa.configuration.ConfigProperties;
import com.eraykosterelioglu.start_spring_jpa.configuration.DataSource;
import com.eraykosterelioglu.start_spring_jpa.configuration.GlobalProperties;
import com.eraykosterelioglu.start_spring_jpa.configuration.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/api/property")
public class PropertySourceController {

    @Autowired
    private GlobalProperties globalProperties;

    @Autowired
    private ConfigProperties configProperties;

    @GetMapping("/datasource")
    public DataSource getDataSource() {
        DataSource dataSource = new DataSource();
        dataSource.setUrl(globalProperties.getUrl());
        dataSource.setUsername(globalProperties.getUrl());
        dataSource.setPassword(globalProperties.getPassword());

        return dataSource;
    }

    @GetMapping("/configuration")
    public List<Server> getServer() {
        return configProperties.getServer();
    }

}
