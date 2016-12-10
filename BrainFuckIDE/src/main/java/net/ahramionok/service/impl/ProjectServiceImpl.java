package net.ahramionok.service.impl;

import net.ahramionok.model.Project;
import net.ahramionok.model.User;
import net.ahramionok.repository.ProjectRepository;
import net.ahramionok.repository.UserRepository;
import net.ahramionok.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by Kirill on 07.12.2016.
 */

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public Project findByUserByIdUser(User user) {
        return projectRepository.findByUserByIdUser(user);
    }

    @Override
    public Project findByProjectName(String projectName) {
        return projectRepository.findByProjectName(projectName);
    }

    @Override
    public Project findByIdProject(Integer idProject) {
        return projectRepository.findByIdProject(idProject);
    }

    @Override
    public void save(Project project) {
        projectRepository.save(project);
    }

    @Override
    public void deleteByIdProject(Integer idProject) {
        projectRepository.deleteByIdProject(idProject);
    }

    @Override
    public Collection<Project> findAll() {
        return projectRepository.findAll();
    }

    @Override
    public void update(Integer idProject, String content) {
        Project currentProject = projectRepository.findByIdProject(idProject);
        currentProject.setProjectContent(content);
        projectRepository.save(currentProject);
    }

    @Override
    public Collection<Project> findAllByIdUser(User user) {
        return projectRepository.findAllByUserByIdUser(user);
    }
}
