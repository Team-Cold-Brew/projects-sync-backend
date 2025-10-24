package projectSync.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import projectSync.model.Project;
import projectSync.service.ProjectService;

import java.util.List;

@RestController
@RequestMapping("api/projects")
public class ProjectController {

    private final ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public List<Project> findAll(){
        return projectService.findAll();
    }

    @PostMapping
    public Project create(@RequestBody Project project){
        return projectService.create(project);
    }
}
