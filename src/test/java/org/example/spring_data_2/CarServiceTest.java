package org.example.spring_data_2;

import org.example.spring_data_2.dto.CarDtoRs;
import org.example.spring_data_2.entity.Car;
import org.example.spring_data_2.mapper.CarMapper;
import org.example.spring_data_2.repository.CarDao;
import org.example.spring_data_2.repository.CarLogDao;
import org.example.spring_data_2.service.CarService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
public class CarServiceTest {
    @SpyBean
    private CarDao carDao;
    @MockBean
    private CarMapper carMapper;
    @MockBean
    private CarLogDao carLogDao;
    @Autowired
    private CarService carService;
    @Autowired
    private EntityManager entityManager;

    private Long createdId;

    @BeforeEach
    public void init() {
        Car targetCar = new Car("black", 10_000d, "Audi", new BigDecimal(10_000));
        carDao.saveAndFlush(targetCar);
        createdId = targetCar.getId();
    }

    @AfterEach
    public void after() {
        carDao.deleteAll();
    }

    @Test
    public void getCarByColorAndPrice() {
        CarDtoRs input = CarDtoRs.builder()
                .brand("Audi")
                .color("black")
                .price(new BigDecimal(10_000))
                .mileage(10_000d)
                .build();
        Car targetCar = new Car("black", 10_000d, "Audi", new BigDecimal(10_000));

        Mockito.when(carDao.findByColorAndPrice("black", new BigDecimal(10_000)))
                .thenReturn(List.of(targetCar));
        Mockito.when(carMapper.castFromEntity(targetCar)).thenReturn(input);

        List<CarDtoRs> actual = carService.getCarByColorAndPrice("black", new BigDecimal(10_000));

        CarDtoRs expectedcarDtoRs = CarDtoRs.builder()
                .brand("Audi")
                .color("black")
                .price(new BigDecimal(10_000))
                .mileage(10_000d)
                .build();
        List<CarDtoRs> expected = List.of(expectedcarDtoRs);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void deleteCarById() {
        Boolean actual = carService.deleteCarById(createdId);
        boolean expected = !carDao.existsById(createdId);
        Assertions.assertEquals(expected, actual);
    }
}
