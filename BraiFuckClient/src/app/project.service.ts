import { Injectable } from '@angular/core';
import { Headers, Http, Request, Response, RequestOptions } from '@angular/http';
import {Observable} from 'rxjs';
import { Project } from './Project';
import 'rxjs/add/operator/map';

@Injectable()
export class ProjectService {
private headers = new Headers({'Content-type': 'application/json'});
private projectsUrl = 'http://localhost:8080/project/';

  constructor(private http: Http) { }
 
  getProjects(): Observable<Project[]>{
    return this.http.get(this.projectsUrl+'all')
              .map(response => <Project[]>response.json());           
  };
  
  
  getProject(idProject:number){
    return this.http.get(this.projectsUrl+idProject)
                    .map(response => <Project>response.json());
  }

  deleteProject(idProject:number){
    let headers = new Headers();
    headers.append('Content-Type', 'application/json');
    return this.http.delete(this.projectsUrl+"delete/"+idProject, {headers: headers})
    .map(response => <Project[]>response.json());
  }
  updateProject(project:Project){
    let headers = new Headers();
    headers.append('Content-Type', 'application/json');
    console.log(JSON.stringify(project));
     return this.http.post(this.projectsUrl+ "update",JSON.stringify(project), {headers: headers})
    .map(response => <Project> response.json());
  }
  saveProject(project:Project){
    let headers = new Headers();
    headers.append('Content-Type', 'application/json');
    console.log("может быть пиздец");
    console.log(JSON.stringify(project));
    return this.http.put(this.projectsUrl+ "save-project", JSON.stringify(project), {headers: headers})
    .map(response => <Project[]> response.json());;
    
  }

}

