# Car Parser App

## Overview
A Java command-line application to parse, filter, sort, and export car data from XML and CSV files.

## Build & Run
```bash
mvn clean package
java -jar target/car-parser-app-1.0-SNAPSHOT-jar-with-dependencies.jar --input <file> --filter <criteria> --sort <field> --output <format>
```

## Features
- Parse XML and CSV car data
- Filter by brand, price, release date
- Sort by price, release year, and currency-based criteria
- Output in Table, JSON, or XML formats

## CLI Usage
See `com.carparser.cli.CommandLineHandler` for detailed argument options.
