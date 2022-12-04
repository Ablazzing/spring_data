package org.example.spring_data_2.controller;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import java.math.BigDecimal;

@Builder
@Data
public class CarDtoRq {
    private String color;
    private Double mileage;
    private String brand;
    private BigDecimal price;
}
