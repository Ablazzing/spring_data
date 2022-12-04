package org.example.spring_data_2.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

//У машины есть следующие свойства:
//        цвет, километраж, марка, цена
@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Car {
    public Car(String color, @NonNull Double mileage, @NonNull String brand, @NonNull BigDecimal price) {
        this.color = color;
        this.mileage = mileage;
        this.brand = brand;
        this.price = price;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(nullable = false)
    private String color;

    @Column(nullable = false)
    @NonNull
    private Double mileage;

    @Column(nullable = false)
    @NonNull
    private String brand;

    @Column(nullable = false)
    @NonNull
    private BigDecimal price;
}
