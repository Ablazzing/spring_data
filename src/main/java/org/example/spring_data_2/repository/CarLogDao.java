package org.example.spring_data_2.repository;

import org.example.spring_data_2.entity.CarLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarLogDao extends JpaRepository<CarLog, Long> {
}
