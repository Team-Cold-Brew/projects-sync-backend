package projectSync.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projectSync.model.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

}
