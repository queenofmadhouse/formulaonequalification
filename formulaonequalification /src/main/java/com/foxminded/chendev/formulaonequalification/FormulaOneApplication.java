package com.foxminded.chendev.formulaonequalification;

import java.io.IOException;
import java.util.TreeSet;

import com.foxminded.chendev.formulaonequalification.entity.RaceFactory;
import com.foxminded.chendev.formulaonequalification.entity.Racer;
import com.foxminded.chendev.formulaonequalification.parser.AbbreviationsFileParser;
import com.foxminded.chendev.formulaonequalification.parser.AbbreviationsFileParserImpl;
import com.foxminded.chendev.formulaonequalification.parser.DateTimeFileParser;
import com.foxminded.chendev.formulaonequalification.parser.DateTimeFileParserImpl;
import com.foxminded.chendev.formulaonequalification.provider.RaceViewProvider;
import com.foxminded.chendev.formulaonequalification.reader.NIOFileReader;
import com.foxminded.chendev.formulaonequalification.validator.FileReaderValidator;

public class FormulaOneApplication {
    public static void main(String[] argsc) throws IOException {
        String abbreviationsFile = "/Users/queenofmadhouse/taskfive/abbreviations.txt";
        String startLogFile = "/Users/queenofmadhouse/taskfive/start.log";
        String endLogFile = "/Users/queenofmadhouse/taskfive/end.log";
        
        FileReaderValidator validator = new FileReaderValidator();
        
        validator.validate(abbreviationsFile);
        validator.validate(startLogFile);
        validator.validate(endLogFile);
        
        RaceViewProvider viewProvider = new RaceViewProvider();
        NIOFileReader fileReader = new NIOFileReader();
        AbbreviationsFileParser abbreviationsFileParser = new AbbreviationsFileParserImpl(fileReader);
        DateTimeFileParser dateTimeFileParser = new DateTimeFileParserImpl(fileReader);
        RaceFactory raceFactory = new RaceFactory(abbreviationsFileParser, dateTimeFileParser);
        
        TreeSet<Racer> race = raceFactory.createRace(abbreviationsFile, startLogFile, endLogFile);
        System.out.println(viewProvider.provideView(race));
    }
}
