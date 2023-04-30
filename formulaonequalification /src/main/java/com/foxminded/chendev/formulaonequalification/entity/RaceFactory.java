package com.foxminded.chendev.formulaonequalification.entity;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.TreeSet;

import com.foxminded.chendev.formulaonequalification.parser.AbbreviationsFileParser;
import com.foxminded.chendev.formulaonequalification.parser.DateTimeFileParser;

public class RaceFactory {

    private AbbreviationsFileParser abbreviationsFileParser;
    private DateTimeFileParser dateTimeFileParser;
    

    public RaceFactory(AbbreviationsFileParser abbreviationsFileParser, DateTimeFileParser dateTimeFileParser) {
        this.abbreviationsFileParser = abbreviationsFileParser;
        this.dateTimeFileParser = dateTimeFileParser;
    }

    public TreeSet<Racer> createRace(String abbreviationsFile, String startLogFile, String endLogFile) throws IOException {
        
        Map<String, String[]> abbreviationsData = abbreviationsFileParser.parseAbbreviationsFile(abbreviationsFile);
        Map<String, LocalDateTime> startLogData = dateTimeFileParser.parseDateTimeFile(startLogFile);
        Map<String, LocalDateTime> endLogData = dateTimeFileParser.parseDateTimeFile(endLogFile);
        
        TreeSet<Racer> racers = new TreeSet<>();

        for (String abbreviation : abbreviationsData.keySet()) {
            String[] racerInfo = abbreviationsData.get(abbreviation);
            String racerName = racerInfo[0];
            String racerTeam = racerInfo[1];

            LocalDateTime startTime = startLogData.get(abbreviation);
            LocalDateTime endTime = endLogData.get(abbreviation);
            Duration racerBestTime = Duration.between(startTime, endTime);
            
            Racer racer = Racer.builder()
                    .withRacerName(racerName)
                    .withRacerTeam(racerTeam)
                    .withRacerBestTime(racerBestTime)
                    .build();
            
            racers.add(racer);
        }

        return racers;
    }
}
