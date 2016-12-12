package net.ahramionok.controller;

import net.ahramionok.model.Project;
import net.ahramionok.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
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
    @RequestMapping(value = "/project/name", method = RequestMethod.GET)
    public ResponseEntity<Project> findByProjectName(@Param("projectName") String projectName, @Param("qwe") String qwe){
       Project project = projectService.findByProjectName(projectName);
       if(project == null) {
           ResponseEntity.notFound();
       }
       return ResponseEntity.ok(project);
//        return findByProjectName(projectName);
    }

    @RequestMapping(value = "/project/{idProject}")
    public Project findByIdProject(@PathVariable String idProject){
        return projectService.findByIdProject(Integer.valueOf(idProject));
    }

    @RequestMapping(value = "/project/{idProject}", method = RequestMethod.DELETE)
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
