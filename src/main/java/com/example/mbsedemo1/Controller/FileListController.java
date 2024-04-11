package com.example.mbsedemo1.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

@RestController
public class FileListController {

    private static final String UPLOAD_DIR = "./uploads/";

    @GetMapping("/files")
    public String listFiles() {
        try {
            return Files.walk(Paths.get(UPLOAD_DIR))
                    .filter(Files::isRegularFile)
                    .map(Path::getFileName)
                    .map(Path::toString)
                    .collect(Collectors.joining(", "));
        } catch (IOException e) {
            e.printStackTrace();
            return "Failed to list files: " + e.getMessage();
        }
    }
}
