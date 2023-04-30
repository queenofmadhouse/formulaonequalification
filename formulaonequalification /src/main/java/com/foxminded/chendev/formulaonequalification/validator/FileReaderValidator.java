package com.foxminded.chendev.formulaonequalification.validator;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;

import com.foxminded.chendev.formulaonequalification.exception.FileReaderException;

public class FileReaderValidator implements Validator {

    @Override
    public void validate(String fileName) {
        if (!canAccessFile(fileName)) {
            throw new FileReaderException("File can't be find/probloems with accese");
        }
    }
    
    public static boolean canAccessFile(String filePath) {
        Path path = Paths.get(filePath);
        return Files.exists(path) && Files.isReadable(path);
    }
}
