package com.carparser.parser;

import com.carparser.exception.CarDataException;
import com.carparser.model.Car;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.StringReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CsvParser {
    public List<Car> parse(String csv) throws CarDataException {
        try (CSVParser parser = CSVFormat.DEFAULT
                .withHeader()
                .parse(new StringReader(csv))) {
            List<Car> cars = new ArrayList<>();
            for (CSVRecord r : parser) {
                Car car = new Car();
                car.setBrand(r.get("brand"));
                car.setModel(r.get("model"));
                car.setPriceUSD(Double.parseDouble(r.get("priceUSD")));
                car.setReleaseDate(LocalDate.parse(r.get("releaseDate")));
                cars.add(car);
            }
            return cars;
        } catch (Exception e) {
            throw new CarDataException("CSV parsing error: " + e.getMessage());
        }
    }
}