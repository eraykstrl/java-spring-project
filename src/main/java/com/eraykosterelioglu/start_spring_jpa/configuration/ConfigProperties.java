package com.eraykosterelioglu.start_spring_jpa.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
@ConfigurationProperties(value = "app")
public class ConfigProperties {

    private List<Server> server;
}
