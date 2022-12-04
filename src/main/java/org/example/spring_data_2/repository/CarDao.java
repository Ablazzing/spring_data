package org.example.spring_data_2.repository;

import org.example.spring_data_2.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface CarDao extends JpaRepository<Car, Long> {

    List<Car> findByColorAndPrice(String color, BigDecimal price);

    @Query(value = "select * from car u where u.color=black", nativeQuery = true)
    List<Car> findBlackCars();
}
