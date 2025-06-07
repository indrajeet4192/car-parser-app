package com.carparser.service;

import com.carparser.model.Car;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CarService {
    public List<Car> filterAndSortCars(List<Car> cars, String brand, Double price, LocalDate date, String sortField, boolean desc) {
        return cars.stream()
                .filter(c -> brand == null || c.getBrand().equalsIgnoreCase(brand))
                .filter(c -> price == null || c.getPriceUSD() <= price)
                .filter(c -> date == null || c.getReleaseDate().equals(date))
                .sorted(getComparator(sortField, desc))
                .collect(Collectors.toList());
    }

    private Comparator<Car> getComparator(String field, boolean desc) {
        Comparator<Car> comp;
        if ("price".equalsIgnoreCase(field)) {
            comp = Comparator.comparing(Car::getPriceUSD);
        } else {
            comp = Comparator.comparing(Car::getReleaseDate);
        }
        return desc ? comp.reversed() : comp;
    }
}