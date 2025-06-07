package com.carparser.parser;

import com.carparser.exception.CarDataException;
import com.carparser.model.Car;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.util.List;

public class XmlParser {
    public List<Car> parse(String xml) throws CarDataException {
        try {
            XmlMapper mapper = new XmlMapper();
            return mapper.readValue(xml, mapper.getTypeFactory().constructCollectionType(List.class, Car.class));
        } catch (Exception e) {
            throw new CarDataException("XML parsing error: " + e.getMessage());
        }
    }
}