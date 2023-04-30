package com.foxminded.chendev.formulaonequalification.parser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.foxminded.chendev.formulaonequalification.reader.FileReader;

@ExtendWith(MockitoExtension.class)
class DateTimeFileParserImplTest {
    
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss.SSS");

    @Mock
    private FileReader fileReader;

    @InjectMocks
    private DateTimeFileParserImpl dateTimeFileParser;

    @Test
    void testParseDateTimeFile() {
        String fileName = "datetime.txt";
        List<String> lines = Arrays.asList(
                "MES2018-05-24_12:05:58.778",
                "RGH2018-05-24_12:06:27.441",
                "SPF2018-05-24_12:13:13.883"
                );
        when(fileReader.readFile(fileName)).thenReturn(Stream.of(lines.toArray(new String[0])));

        Map<String, LocalDateTime> expected = new HashMap<>();

        expected.put("MES", LocalDateTime.parse("2018-05-24_12:05:58.778", formatter));
        expected.put("RGH", LocalDateTime.parse("2018-05-24_12:06:27.441", formatter));
        expected.put("SPF", LocalDateTime.parse("2018-05-24_12:13:13.883", formatter));

        Map<String, LocalDateTime> result = dateTimeFileParser.parseDateTimeFile(fileName);

        assertEquals(expected, result);
        verify(fileReader).readFile(fileName);
    }
}
