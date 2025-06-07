package com.carparser.cli;

import com.carparser.exception.CarDataException;
import com.carparser.model.Car;
import com.carparser.parser.CsvParser;
import com.carparser.parser.XmlParser;
import com.carparser.service.CarService;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

public class CommandLineHandler {
    private String inputFile;
    private String brand;
    private Double price;
    private LocalDate date;
    private String sortField;
    private boolean descending = true;
    private String outputFormat;

    public CommandLineHandler(String[] args) throws CarDataException {
        // Basic args parsing (for brevity, not fully robust)
        for (String arg : args) {
            if (arg.startsWith("--input")) inputFile = arg.split("=")[1];
            else if (arg.startsWith("--filter-brand")) brand = arg.split("=")[1];
            else if (arg.startsWith("--filter-price")) price = Double.valueOf(arg.split("=")[1]);
            else if (arg.startsWith("--filter-date")) date = LocalDate.parse(arg.split("=")[1]);
            else if (arg.startsWith("--sort")) sortField = arg.split("=")[1];
            else if (arg.startsWith("--output")) outputFormat = arg.split("=")[1];
        }
        if (inputFile == null || outputFormat == null) {
            throw new CarDataException("Input file and output format are required.");
        }
    }

    public List<Car> parseInput() throws CarDataException {
        try {
            String content = new String(Files.readAllBytes(Paths.get(inputFile)));
            if (inputFile.endsWith(".xml")) {
                return new XmlParser().parse(content);
            } else if (inputFile.endsWith(".csv")) {
                return new CsvParser().parse(content);
            } else {
                throw new CarDataException("Unsupported file format.");
            }
        } catch (Exception e) {
            throw new CarDataException(e.getMessage());
        }
    }

    public List<Car> process(List<Car> cars) {
        return new CarService().filterAndSortCars(cars, brand, price, date, sortField, descending);
    }

    public String getOutputFormat() {
        return outputFormat;
    }
}