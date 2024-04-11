package com.example.mbsedemo1.Controller;

import com.example.mbsedemo1.Entity.Project;
import com.example.mbsedemo1.Entity.ProjectCreationRequest;
import com.example.mbsedemo1.Service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    private final ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/")
    public List<Project> getAllProjects() {
        return projectService.getAllProjects();
    }

    @PostMapping("/create")
    public ResponseEntity<String> createProject(@RequestBody Project project) {
        // 假设根据文件名称创建的项目名与文件名相同，或者进行一定的转换

        projectService.createProject(project);

        return new ResponseEntity<>("Project created successfully with file name: " + project.getName(), HttpStatus.CREATED);
    }
    // 其他与项目相关的操作...
}
