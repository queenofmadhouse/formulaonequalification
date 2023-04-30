package com.foxminded.chendev.formulaonequalification.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.foxminded.chendev.formulaonequalification.parser.AbbreviationsFileParser;
import com.foxminded.chendev.formulaonequalification.parser.DateTimeFileParser;

@ExtendWith(MockitoExtension.class)
class RaceFactoryTest {

    @Mock
    private AbbreviationsFileParser abbreviationsFileParser;

    @Mock
    private DateTimeFileParser dateTimeFileParser;

    @InjectMocks
    private RaceFactory raceFactory;

    @Test
    void createRaceShouldCreateRaceWithParsedData() throws IOException {
        
        String abbreviationsFile = "abbreviations.txt";
        String startLogFile = "start.log";
        String endLogFile = "end.log";

        Map<String, String[]> abbreviationsData = new HashMap<>();
        abbreviationsData.put("DRR", new String[]{"Daniel Ricciardo", "RED BULL RACING TAG HEUER"});
        abbreviationsData.put("SVF", new String[]{"Sebastian Vettel", "FERRARI"});

        when(abbreviationsFileParser.parseAbbreviationsFile(abbreviationsFile)).thenReturn(abbreviationsData);

        Map<String, LocalDateTime> startLogData = new HashMap<>();
        startLogData.put("DRR", LocalDateTime.parse("2018-05-24T12:15:24.067"));
        startLogData.put("SVF", LocalDateTime.parse("2018-05-24T12:04:03.332"));

        when(dateTimeFileParser.parseDateTimeFile(startLogFile)).thenReturn(startLogData);

        Map<String, LocalDateTime> endLogData = new HashMap<>();
        endLogData.put("DRR", LocalDateTime.parse("2018-05-24T12:15:24.169"));
        endLogData.put("SVF", LocalDateTime.parse("2018-05-24T12:04:03.433"));

        when(dateTimeFileParser.parseDateTimeFile(endLogFile)).thenReturn(endLogData);

        TreeSet<Racer> expectedRacers = new TreeSet<>();
        expectedRacers.add(Racer.builder()
                .withRacerName("Daniel Ricciardo")
                .withRacerTeam("RED BULL RACING TAG HEUER")
                .withRacerBestTime(Duration.ofMillis(102))
                .build());
        expectedRacers.add(Racer.builder()
                .withRacerName("Sebastian Vettel")
                .withRacerTeam("FERRARI")
                .withRacerBestTime(Duration.ofMillis(101))
                .build());

        TreeSet<Racer> actualRacers = raceFactory.createRace(abbreviationsFile, startLogFile, endLogFile);

        assertEquals(expectedRacers, actualRacers);
    }
}
