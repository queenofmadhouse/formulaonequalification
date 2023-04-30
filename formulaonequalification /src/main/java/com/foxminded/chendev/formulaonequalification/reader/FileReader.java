package com.foxminded.chendev.formulaonequalification.reader;

import java.util.stream.Stream;

public interface FileReader {
    public Stream<String> readFile(String fileName);
}
