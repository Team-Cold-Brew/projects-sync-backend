package projectSync.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projectSync.exception.ResourceNotFoundException;
import projectSync.model.Project;
import projectSync.repository.ProjectRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectService(ProjectRepository projectRepository){
        this.projectRepository = projectRepository;
    }

    public List<Project> findAll(){
        return projectRepository.findAll();
    }

    public Project create(Project project){
        return projectRepository.save(project);
    }

    public Project update(Project project, Long id){
        Project existentProject = projectRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException(""));



    }
}
