package com.example.mbsedemo1.Service;

import com.example.mbsedemo1.Entity.Project;
import com.example.mbsedemo1.Mapper.ProjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProjectService {

    private final ProjectMapper projectMapper;

    @Autowired
    public ProjectService(ProjectMapper projectMapper) {
        this.projectMapper = projectMapper;
    }

    public void createProject(Project project) {
        projectMapper.insert(project);
    }

    public Project getProjectById(int id) {
        return projectMapper.findById(id);
    }

    public List<Project> getAllProjects() {
        return projectMapper.findAll();
    }

    public void updateProject(Project project) {
        projectMapper.update(project);
    }

    public void deleteProject(int id) {
        projectMapper.delete(id);
    }
}
