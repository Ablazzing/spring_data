package org.example.spring_data_2.mapper;

import org.example.spring_data_2.dto.CarDtoRq;
import org.example.spring_data_2.dto.CarDtoRs;
import org.example.spring_data_2.entity.Car;
import org.springframework.stereotype.Component;

@Component
public class CarMapper {
    public Car castFromDto(CarDtoRq carDtoRq) {
        return new Car(carDtoRq.getColor(), carDtoRq.getMileage(), carDtoRq.getBrand(), carDtoRq.getPrice());
    }

    public CarDtoRs castFromEntity(Car car) {
        return CarDtoRs.builder()
                .brand(car.getBrand())
                .color(car.getColor())
                .price(car.getPrice())
                .mileage(car.getMileage())
                .build();
    }
}
