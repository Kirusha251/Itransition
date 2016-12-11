package net.ahramionok.controller;

import net.ahramionok.model.Project;
import net.ahramionok.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * @author Kirill Achramionok
 */

@RestController
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @RequestMapping(value = "/project/all")
    public Collection<Project> getAllProjects() {
        return projectService.findAll();
    }

    @RequestMapping(value = "/project/all-by-user")
    public Collection<Project> getAllProjectsByIdUser(@PathVariable String user){
        return projectService.findAllByIdUser(Integer.valueOf(user));
    }
    @RequestMapping(value = "/project/name")
    public Project findByProjectName(@PathVariable String projectName){
        return findByProjectName(projectName);
    }

    @RequestMapping(value = "/project/id")
    public Project findByIdProject(@PathVariable String idProject){
        return projectService.findByIdProject(Integer.valueOf(idProject));
    }

    @RequestMapping(value = "/project/delete")
    public Collection<Project> deleteByIdProject(@PathVariable String idProject){
        projectService.deleteByIdProject(Integer.valueOf(idProject));
        return projectService.findAll();
    }

    @RequestMapping(value = "/project/save")
    public Collection<Project> save(@PathVariable String project){
        return projectService.findAll();
    }

    @RequestMapping(value = "/project/userid")
    public Project findByUserId(@PathVariable String user){
        return projectService.findByIdUser(Integer.valueOf(user));
    }

    @RequestMapping(value = "/project/update")
    public Project updateProject(@RequestBody Project project){
        projectService.update(project.getIdProject(),project.getProjectContent());
        return projectService.findByIdProject(project.getIdProject());
    }
}