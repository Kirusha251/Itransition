import { Injectable } from '@angular/core';
import { Headers, Http, Request, Response } from '@angular/http';
import {Observable} from 'rxjs';
import { Project } from './Project';

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

  deleteProject(idProject:number): Observable<Project[]>{
    return this.http.delete(this.projectsUrl + idProject)
                    .map(response => <Project[]>response.json());
  }

}
