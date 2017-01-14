import { Injectable } from '@angular/core';
import { Http, Headers, Response } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import {Authentication} from './Authentication';

@Injectable()
export class AuthenticationService {

  constructor(private http: Http) { }
   login(username: string, password: string) {
    let headers = new Headers();
    let auth = new Authentication(username,password);
    console.log(JSON.stringify({username,password}));
    
    headers.append('Content-Type', 'application/json');
        return this.http.
        post(
            ' http://localhost:8080/login'
            , JSON.stringify({username,password})
            , {headers:headers})
            .map(response => response.json())
            .map((response:Response) =>{
                if(response.status===200){
                    console.log("200 хуев");
                    localStorage.setItem("isLogin","true");
                }
                if(response.status===401){
                    console.log("403 хуя");
                }
            });
    }

    logout() {
        localStorage.removeItem('auth_token');
        localStorage.setItem('isLogin','false');
    }


}
