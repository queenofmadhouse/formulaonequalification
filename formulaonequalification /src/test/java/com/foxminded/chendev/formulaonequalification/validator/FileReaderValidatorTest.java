package com.foxminded.chendev.formulaonequalification.validator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import com.foxminded.chendev.formulaonequalification.exception.FileReaderException;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;

class FileReaderValidatorTest {
    
    private final FileReaderValidator fileReaderValidator = new FileReaderValidator();

    @Test
    void shouldNotThrowExceptionWhenFileExistsAndIsReadable(@TempDir Path tempDir) throws IOException {
        Path testFile = tempDir.resolve("testFile.txt");
        Files.createFile(testFile);

        assertDoesNotThrow(() -> fileReaderValidator.validate(testFile.toString()));
    }

    @Test
    void shouldThrowExceptionWhenFileDoesNotExist(@TempDir Path tempDir) {
        Path nonExistentFile = tempDir.resolve("nonExistentFile.txt");

        assertThrows(FileReaderException.class, () -> fileReaderValidator.validate(nonExistentFile.toString()));
    }

    @Test
    void shouldThrowExceptionWhenFileIsNotReadable(@TempDir Path tempDir) throws IOException {
        Path unreadableFile = tempDir.resolve("unreadableFile.txt");
        Files.createFile(unreadableFile);
        Files.setPosixFilePermissions(unreadableFile, Collections.emptySet());

        assertThrows(FileReaderException.class, () -> fileReaderValidator.validate(unreadableFile.toString()));
    }
}
