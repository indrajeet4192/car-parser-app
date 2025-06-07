package com.carparser.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    private String type;
    private String model;

    @JacksonXmlProperty(localName = "price")
    private Price price;

    @JacksonXmlElementWrapper(localName = "prices")
    @JacksonXmlProperty(localName = "price")
    private List<Price> prices;

    private LocalDate releaseDate;
    private String brand;
}