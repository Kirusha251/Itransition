package net.ahramionok.service;

import net.ahramionok.model.Project;
import net.ahramionok.model.User;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by Kirill on 07.12.2016.
 */


public interface ProjectService {
    Project findByUserByIdUser(User user);
    Project findByProjectName(String projectName);
    Project findByIdProject(Integer idProject);
    void save(Project project);
    void deleteByIdProject(Integer idProject);
    Collection<Project> findAll();
    Collection<Project> findAllByIdUser(User user);
    void update(Integer idProject, String content);
}
