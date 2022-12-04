package org.example.spring_data_2.service;

import lombok.AllArgsConstructor;
import org.example.spring_data_2.dto.CarDtoRq;
import org.example.spring_data_2.dto.CarDtoRs;
import org.example.spring_data_2.entity.Car;
import org.example.spring_data_2.entity.CarLog;
import org.example.spring_data_2.mapper.CarMapper;
import org.example.spring_data_2.repository.CarDao;
import org.example.spring_data_2.repository.CarLogDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CarService {
    private CarDao carDao;
    private CarMapper carMapper;
    private CarLogDao carLogDao;

    @Transactional
    public Long createCar(CarDtoRq carDtoRq) {
        carLogDao.save(new CarLog("create"));
        Car car = carMapper.castFromDto(carDtoRq);
        carDao.save(car);
        return car.getId();
    }

    public List<CarDtoRs> getCarByColorAndPrice(String color, BigDecimal price) {
        return carDao.findByColorAndPrice(color, price).stream()
                .map(e -> carMapper.castFromEntity(e))
                .collect(Collectors.toList());
    }

    public Boolean deleteCarById(Long id) {
        try {
            if (carDao.findById(id).isEmpty()) {
                return false;
            }
            carDao.deleteById(id);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
