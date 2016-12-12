import { Component, OnInit } from '@angular/core';
import {Project} from '../Project';
import { ProjectService } from '../project.service';




@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css'],
  providers:[ProjectService]
})
export class NavBarComponent implements OnInit {
  selectedProject:Project;
  projects: Project [] = [];
  onSelect(project: Project){
    this.selectedProject = project;
  }
  constructor(private projectService: ProjectService) { }

  ngOnInit(): void {
    this.projectService.getProjects()
                       .subscribe(allprojects=> this.projects = allprojects);   
                              
  }

}
