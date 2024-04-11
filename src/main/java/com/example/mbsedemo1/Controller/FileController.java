package com.example.mbsedemo1.Controller;

import com.example.mbsedemo1.DTO.FileCreationRequest;
import com.example.mbsedemo1.Entity.File;
import com.example.mbsedemo1.Service.FileService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
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

    @PostMapping("/create")
    public ResponseEntity<String> createFile(@RequestBody @Valid FileCreationRequest request) {
        File file = new File();
        file.setFolderId(request.getFolderId());
        file.setContent(request.getContent());
        file.setName(request.getName());
        // 假设你在File类中添加了其他必要的属性设置，比如uploadTime等
        fileService.createFile(file);

        return new ResponseEntity<>("File '" + request.getName() + "' created successfully", HttpStatus.CREATED);
    }
    // 其他与文件相关的操作...
}
