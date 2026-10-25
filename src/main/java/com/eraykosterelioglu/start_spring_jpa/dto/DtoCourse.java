package com.eraykosterelioglu.start_spring_jpa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoCourse {

    private String name;

    private BigDecimal price;
}
