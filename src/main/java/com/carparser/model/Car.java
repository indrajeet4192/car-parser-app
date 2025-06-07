package com.carparser.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    private String type;
    private String model;
    private double priceUSD;
    private Map<String, Double> prices;
    private LocalDate releaseDate;
    private String brand;
}