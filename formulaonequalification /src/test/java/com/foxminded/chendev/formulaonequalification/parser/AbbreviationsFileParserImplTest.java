package com.foxminded.chendev.formulaonequalification.parser;

import com.foxminded.chendev.formulaonequalification.reader.FileReader;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AbbreviationsFileParserImplTest {

    @Mock
    private FileReader fileReader;

    @InjectMocks
    private AbbreviationsFileParserImpl parser;

    @Test
    void testParseAbbreviationsFile() {
        String fileName = "abbreviations.txt";
        List<String> lines = Arrays.asList(
                "DRR_Daniel Ricciardo_RED BULL RACING TAG HEUER",
                "SVF_Sebastian Vettel_FERRARI",
                "LHM_Lewis Hamilton_MERCEDES"
                );
        when(fileReader.readFile(fileName)).thenReturn(Stream.of(lines.toArray(new String[0])));

        Map<String, String[]> expected = new HashMap<>();
        expected.put("DRR", new String[]{"Daniel Ricciardo", "RED BULL RACING TAG HEUER"});
        expected.put("SVF", new String[]{"Sebastian Vettel", "FERRARI"});
        expected.put("LHM", new String[]{"Lewis Hamilton", "MERCEDES"});


        Map<String, String[]> result = parser.parseAbbreviationsFile(fileName);

        assertEquals(expected.size(), result.size());
        for (Map.Entry<String, String[]> entry : expected.entrySet()) {
            String[] expectedData = entry.getValue();
            String[] actualData = result.get(entry.getKey());
            assertArrayEquals(expectedData, actualData);
        }
        verify(fileReader).readFile(fileName);
    }
}
