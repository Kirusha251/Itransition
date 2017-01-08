package net.ahramionok.controller;

import net.ahramionok.model.Project;
import net.ahramionok.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
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
    @CrossOrigin
    @RequestMapping(value = "/project/delete/{idProject}", method = RequestMethod.DELETE)
    public Collection<Project> deleteByIdProject(@PathVariable("idProject") String idProject){
        projectService.deleteByIdProject(Integer.valueOf(idProject));
        return projectService.findAll();
    }

    @CrossOrigin
    @RequestMapping(value = "/project/save-project", method = RequestMethod.PUT)
    public Collection<Project> saveProject(@RequestBody Project project){
        System.out.println("100 хуев");
        projectService.save(project);
        return projectService.findAll();
    }

    @RequestMapping(value = "/project/userid")
    public Project findByUserId(@PathVariable String user){
        return projectService.findByIdUser(Integer.valueOf(user));
    }

    @RequestMapping(value = "/project/update", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Project updateProject(@RequestBody Project project){

        projectService.update(project.getIdProject(),project.getProjectContent());
        return projectService.findByIdProject(project.getIdProject());
    }
}
