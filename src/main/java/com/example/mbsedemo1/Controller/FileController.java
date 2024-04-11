package com.example.mbsedemo1.Controller;

import com.example.mbsedemo1.Entity.File;
import com.example.mbsedemo1.Entity.Project;
import com.example.mbsedemo1.Entity.ProjectCreationRequest;
import com.example.mbsedemo1.Service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/files")
public class FileController {

    private final FileService fileService;

    @Autowired
    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @GetMapping("/byFolder/{folderId}")
    public List<File> getFilesByFolder(@PathVariable int folderId) {
        return fileService.getFilesByFolderId(folderId);
    }

    @GetMapping("/{fileId}")
    public File getFileById(@PathVariable int fileId) {
        return fileService.getFileById(fileId);
    }

    // 其他与文件相关的操作...
}
