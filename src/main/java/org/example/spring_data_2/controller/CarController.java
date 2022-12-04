package org.example.spring_data_2.controller;

import lombok.AllArgsConstructor;
import org.example.spring_data_2.dto.CarDtoRq;
import org.example.spring_data_2.dto.CarDtoRs;
import org.example.spring_data_2.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CarController {
    private CarService carService;

    @PostMapping("/car")
    public Long createCar(@RequestBody CarDtoRq carDtoRq) {
        return carService.createCar(carDtoRq);
    }

    @DeleteMapping("/car/{id}")
    public Boolean deleteCar(@PathVariable Long id) {
        return carService.deleteCarById(id);
    }

    @GetMapping("/car")
    public ResponseEntity getCarsByFilterColorAndPrice(@RequestParam String color,
                                                       @RequestParam BigDecimal price) {
        if (color == null || price == null) {
            return new ResponseEntity<>("Цвет или цена не заданы", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(carService.getCarByColorAndPrice(color, price), HttpStatus.OK);
    }

}
