package net.ahramionok.repository;

import net.ahramionok.model.Project;
import net.ahramionok.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * Created by Kirill on 07.12.2016.
 */
public interface ProjectRepository extends JpaRepository<Project,Integer> {
    Project findByUserByIdUser(User user);
    Project findByProjectName(String projectName);
    Project findByIdProject(Integer idProject);
    Collection<Project> findAllByUserByIdUser(User user);
    @Transactional
    void deleteByIdProject(Integer idProject);

}
