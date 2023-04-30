package com.foxminded.chendev.formulaonequalification.parser;

import java.time.LocalDateTime;
import java.util.Map;

public interface DateTimeFileParser {
    public Map<String, LocalDateTime> parseDateTimeFile(String fileName);
}
