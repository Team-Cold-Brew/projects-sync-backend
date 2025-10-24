package projectSync.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projectSync.exception.ResourceNotFoundException;
import projectSync.model.Project;
import projectSync.repository.ProjectRepository;
import java.util.List;


@Service
@Transactional
public class ProjectService {

    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectService(ProjectRepository projectRepository){
        this.projectRepository = projectRepository;
    }


    /**
     * Retrieves all projects from the database.
     *
     * @return A list containing all {@link Project} entities, or an empty list if none are found.
     */
    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    /**
     * Creates and persists a new project.
     *
     * @param project The {@link Project} entity to be created. Must not be null.
     * @return The saved project entity, including the database-generated ID.
     */
    public Project create(Project project) {
        return projectRepository.save(project);
    }

    /**
     * Partially updates an existing project with the provided data.
     * Only non-null fields from the {@code project} parameter will be updated on the existing entity.
     * This method is designed to handle PATCH-style updates.
     *
     * @param project A {@link Project} object containing the fields to update. Null fields are ignored.
     * @param id The ID of the project to update.
     * @return The updated and persisted project entity.
     * @throws ResourceNotFoundException if no project with the specified ID is found.
     */
    public Project update(Project project, Long id) {
        // Find the existing project or throw an exception
        Project existentProject = projectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Project.class, id));

        // Conditionally update each field if a new value is provided
        if (project.getName() != null) {
            existentProject.setName(project.getName());
        }
        if (project.getDescription() != null) {
            existentProject.setDescription(project.getDescription());
        }
        if (project.getResponsible() != null) {
            existentProject.setResponsible(project.getResponsible());
        }
        if (project.getStatus() != null) {
            existentProject.setStatus(project.getStatus());
        }

        return projectRepository.save(existentProject);
    }
}
