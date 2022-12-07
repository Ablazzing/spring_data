package org.example.spring_data_2;

import org.example.spring_data_2.dto.CarDtoRq;
import org.example.spring_data_2.entity.Car;
import org.example.spring_data_2.mapper.CarMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
public class CarMapperTest {
    @Autowired
    private CarMapper carMapper;

    @Test
    public void castFromDto() {
        CarDtoRq input = CarDtoRq.builder()
                .mileage(10_000d)
                .price(new BigDecimal(10_000))
                .color("black")
                .brand("Audi")
                .build();
        Car result = carMapper.castFromDto(input);
        Car expected = new Car("black", 10_000d, "Audi", new BigDecimal(10_000));
        Assertions.assertEquals(expected, result);
    }
}
