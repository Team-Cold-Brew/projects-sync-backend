package projectSync.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

    /**
     * Endpoint for partially updating an existing project.
     *
     * @param id The ID of the project to update, extracted from the URL.
     * @param projectUpdates A Project object containing only the fields to be changed.
     * an existing project.
     * @return The complete and updated project.
     */
    @PatchMapping("/{id}")
    public ResponseEntity<Project> updateProject(@PathVariable Long id, @RequestBody Project projectUpdates) {

        Project updatedProject = projectService.update(projectUpdates, id);
        return ResponseEntity.ok(updatedProject);
    }
}
