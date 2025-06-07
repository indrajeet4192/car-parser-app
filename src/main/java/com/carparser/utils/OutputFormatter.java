package com.carparser.utils;

import com.carparser.model.Car;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.util.List;

public class OutputFormatter {
    public static void format(List<Car> cars, String format) throws Exception {
        if ("json".equalsIgnoreCase(format)) {
            System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(cars));
        } else if ("xml".equalsIgnoreCase(format)) {
            System.out.println(new XmlMapper().writerWithDefaultPrettyPrinter().writeValueAsString(cars));
        } else {
            // Table output
            System.out.printf("%-10s %-10s %-10s %-12s%n", "Brand", "Model", "PriceUSD", "ReleaseDate");
            for (Car c : cars) {
                System.out.printf("%-10s %-10s %-10.2f %-12s%n",
                        c.getBrand(), c.getModel(), c.getPriceUSD(), c.getReleaseDate());
            }
        }
    }
}