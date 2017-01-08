import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import {Project} from '../Project';
import { ProjectService } from '../project.service';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css'],
  providers:[ProjectService]
})
export class NavBarComponent implements OnInit {

  @Input() selectedProject:Project;
  currentContent:string;
  newProject:string;
  projects: Project [] = [];
    
  onSelect(project: Project){
    this.selectedProject = project;
    this.currentContent = project.projectContent;
  }
  constructor(private projectService: ProjectService) { }

  projectDeleted(project:Project){
    console.log("delete");
    this.projectService.deleteProject(project.idProject)
    .subscribe(all => this.projects = all);
    if(this.projects){
    this.selectedProject = this.projects[this.projects.length-1];
    }
  }
  onAddButtonClick(){
    console.log("add new project");
    var project = new Project(0,1,this.newProject," "," ",1);
    this.projects.push(project);
    this.selectedProject = this.projects[this.projects.length-1];
    this.projectService.saveProject(project).subscribe(allprojects=> this.projects = allprojects);
  }
  ngOnInit(): void {
      this.projectService.getProjects()
      .subscribe(allprojects=> this.projects = allprojects);                   
  }

}
