package com.foxminded.chendev.formulaonequalification.reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import com.foxminded.chendev.formulaonequalification.exception.FileReaderException;

public class NIOFileReader implements FileReader{
    @Override
    public Stream<String> readFile(String fileName) {
        try {
            return Files.lines(Paths.get(fileName));
        } catch (IOException e) {
            throw new FileReaderException(e.getMessage());
        }
    }
}
