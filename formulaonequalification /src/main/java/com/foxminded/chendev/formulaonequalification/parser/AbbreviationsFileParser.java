package com.foxminded.chendev.formulaonequalification.parser;

import java.util.Map;

public interface AbbreviationsFileParser {
    Map<String, String[]> parseAbbreviationsFile(String fileName);
}
