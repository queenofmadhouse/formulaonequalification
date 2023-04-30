package com.foxminded.chendev.formulaonequalification.parser;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.AbstractMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.foxminded.chendev.formulaonequalification.reader.FileReader;

public class DateTimeFileParserImpl implements DateTimeFileParser {

    private final FileReader fileReader;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss.SSS");

    public DateTimeFileParserImpl(FileReader fileReader) {
        this.fileReader = fileReader;
    }

    @Override
    public Map<String, LocalDateTime> parseDateTimeFile(String fileName) {
        Stream<String> lines = fileReader.readFile(fileName);
        
        return lines
                .map(line -> new AbstractMap.SimpleEntry<>(
                        line.substring(0, 3),
                        LocalDateTime.parse(line.substring(3), formatter)))
                .collect(Collectors.toMap(
                        (Map.Entry<String, LocalDateTime> entry) -> entry.getKey(),
                        (Map.Entry<String, LocalDateTime> entry) -> entry.getValue()));

    }
}
