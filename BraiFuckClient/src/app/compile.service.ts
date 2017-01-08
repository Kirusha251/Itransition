import { Injectable } from '@angular/core';
import { Headers, Http, Request, Response, RequestOptions } from '@angular/http';
import {Observable} from 'rxjs';
import { Project } from './Project';
import {Compile} from './Compile';
import {CompileResult} from './Compile-Result';
import {CompileMemory} from './Compile-Memory';
import 'rxjs/add/operator/map';
@Injectable()
export class CompileService {
  
  private projectsUrl = 'http://localhost:8080/compile';

  constructor(private http: Http) { }

  compileProject (compileProject:Compile){
    let headers = new Headers();
    headers.append('Content-Type', 'application/json');
    console.log(JSON.stringify(compileProject));
    return this.http.post(this.projectsUrl, JSON.stringify(compileProject), { headers: headers })
    .map(response => response.json());
  }
  compileProjectWithMemory(compile:CompileMemory){
    let headers = new Headers();
    headers.append('Content-Type', 'application/json');
    console.log(JSON.stringify(compile));
    return this.http.post(this.projectsUrl+"/change-memory",JSON.stringify(compile) , { headers: headers })
    .map(response => response.json());
  
  }

  withBreakPointProject(compileProject:Compile){
    let headers = new Headers();
    headers.append('Content-Type', 'application/json');
    console.log(JSON.stringify(compileProject));
    return this.http.post(this.projectsUrl+"/with-break-point",JSON.stringify(compileProject) , { headers: headers })
    .map(response => response.json());
  }

  debugProject(compileProject:Compile){
    let headers = new Headers();
    headers.append('Content-Type', 'application/json');
    console.log(JSON.stringify(compileProject));
    return this.http.post(this.projectsUrl+"/debug-project",JSON.stringify(compileProject) , { headers: headers })
    .map(response => response.json());
  }

}
