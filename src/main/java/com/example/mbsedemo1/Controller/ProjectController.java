package com.example.mbsedemo1.Controller;

import com.example.mbsedemo1.DTO.ProjectCreationRequest;
import com.example.mbsedemo1.Entity.Project;
import com.example.mbsedemo1.Service.ProjectService;
import jakarta.validation.Valid;
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
    public ResponseEntity<String> createProject(@RequestBody @Valid ProjectCreationRequest request) {
        Project project = new Project();
        project.setName(request.getName());
        // 设置其他默认属性或从request中获取其他属性
        projectService.createProject(project);

        return new ResponseEntity<>("Project '" + request.getName() + "' created successfully", HttpStatus.CREATED);
    }
    // 其他与项目相关的操作...
}
