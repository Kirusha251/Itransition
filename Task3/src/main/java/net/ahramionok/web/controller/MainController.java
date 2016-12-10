package net.ahramionok.web.controller;

import com.sun.org.apache.regexp.internal.RE;
import net.ahramionok.web.model.CompileResult;
import net.ahramionok.web.model.Project;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Kirill on 06.12.2016.
 */
@RestController
public class MainController {
    @RequestMapping(value = "/projects/project")
    public Project getProject(){
        return new Project(1,"test","return: null","txt.path",false);
    }

    @RequestMapping(value = "project/compile")
     public CompileResult compileProject(){
        return  new CompileResult();
    }
    @RequestMapping(value = "/projects")
    public Collection<Project> getProjects(){
        return new ArrayList<Project>();
    }
}
