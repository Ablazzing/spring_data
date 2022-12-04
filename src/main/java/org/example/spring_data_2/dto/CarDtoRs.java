package org.example.spring_data_2.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class CarDtoRs {
    private String color;
    private Double mileage;
    private String brand;
    private BigDecimal price;
}
