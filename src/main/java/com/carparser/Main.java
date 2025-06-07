package com.carparser;

import com.carparser.cli.CommandLineHandler;
import com.carparser.exception.CarDataException;
import com.carparser.model.Car;
import com.carparser.parser.CsvParser;
import com.carparser.parser.XmlParser;
import com.carparser.service.CarService;
import com.carparser.utils.OutputFormatter;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            CommandLineHandler handler = new CommandLineHandler(args);
            List<Car> cars = handler.parseInput();
            List<Car> processed = handler.process(cars);
            OutputFormatter.format(processed, handler.getOutputFormat());
        } catch (CarDataException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}