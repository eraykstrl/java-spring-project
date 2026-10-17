package com.eraykosterelioglu.start_spring_jpa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoHome {

    private BigDecimal price;

    private List<DtoRoom> room;
}
