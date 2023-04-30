package com.foxminded.chendev.formulaonequalification.parser;

import java.util.AbstractMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.foxminded.chendev.formulaonequalification.reader.FileReader;

public class AbbreviationsFileParserImpl implements AbbreviationsFileParser {
    
    private final FileReader fileReader;

    public AbbreviationsFileParserImpl(FileReader fileReader) {
        this.fileReader = fileReader;
    }

    @Override
    public Map<String, String[]> parseAbbreviationsFile(String fileName) {
        Stream<String> lines = fileReader.readFile(fileName);

        return lines
                .filter(line -> line.contains("_"))
                .map(line -> {
                    String[] parts = line.split("_");
                    String abbreviation = parts[0];
                    String racerName = parts[1];
                    String racerTeam = parts[2];
                    return new AbstractMap.SimpleEntry<>(abbreviation, new String[]{racerName, racerTeam});
                })
                .collect(Collectors.toMap(
                        (Map.Entry<String, String[]> entry) -> entry.getKey(),
                        (Map.Entry<String, String[]> entry) -> entry.getValue()));

    }
}
