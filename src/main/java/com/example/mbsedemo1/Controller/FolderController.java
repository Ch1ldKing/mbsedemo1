package com.example.mbsedemo1.Controller;

import com.example.mbsedemo1.Entity.Folder;
import com.example.mbsedemo1.Service.FolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/folders")
public class FolderController {

    private final FolderService folderService;

    @Autowired
    public FolderController(FolderService folderService) {
        this.folderService = folderService;
    }

    @GetMapping("/byProject/{projectId}")
    public List<Folder> getFoldersByProject(@PathVariable int projectId) {
        return folderService.getFoldersByProjectId(projectId);
    }

    // 其他与文件夹相关的操作...
}
