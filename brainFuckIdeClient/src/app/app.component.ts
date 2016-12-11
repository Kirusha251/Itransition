import { Component } from '@angular/core';
import {Project } from './Project';

const PROJECTS: Project[] = [
{ id_Project:1, id_User:1,projectName: 'Misha', projectContent: ' ', compileResult: ' ', isLastOpene: false },
{ id_Project:2, id_User:1,projectName: 'Ilya', projectContent: ' ', compileResult: ' ', isLastOpene: false },
{id_Project:3, id_User:1,projectName: 'Kirill', projectContent: ' ', compileResult: ' ', isLastOpene: false }
];

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})


export class AppComponent {
  title = 'app works!';
  projects = PROJECTS;
  selectedProject: Project;
  onSelect(project: Project): void{
    this.selectedProject = project;
  }
}
