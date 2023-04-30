package com.foxminded.chendev.formulaonequalification.reader;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import com.foxminded.chendev.formulaonequalification.exception.FileReaderException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class NIOFileReaderTest {

    private final NIOFileReader fileReader = new NIOFileReader();

    @TempDir
    Path tempDir;

    @Test
    void testReadFile() throws IOException {
        Path tempFile = tempDir.resolve("testFile.txt");
        List<String> content = new ArrayList<>();
        content.add("line1"); 
        content.add("line2");
        content.add("line3");

        Files.write(tempFile, content, StandardCharsets.UTF_8);

        FileReader fileReader = new NIOFileReader();
        Stream<String> resultStream = fileReader.readFile(tempFile.toString()); 
        List<String> result = resultStream.collect(Collectors.toList());

        assertEquals(content, result);
    }
    
    @Test
    void testReadFileException() {
        String nonExistentFile = "nonExistentFile.txt";
        
        assertThrows(FileReaderException.class, () -> fileReader.readFile(nonExistentFile));
    }
}
