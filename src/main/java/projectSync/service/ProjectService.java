package projectSync.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projectSync.model.Project;
import projectSync.repository.ProjectRepository;

import java.util.List;

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
}
