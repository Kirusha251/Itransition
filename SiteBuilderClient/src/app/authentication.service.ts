import { Injectable } from '@angular/core';
import { Http, Headers, Response } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';

@Injectable()
export class AuthenticationService {

  constructor(private http: Http) { }
   login(email: string, password: string) {
    let headers = new Headers();
    headers.append('Content-Type', 'application/json');
        return this.http.
        post(
            ' http://localhost:8080/login'
            , JSON.stringify({email,password})
            , {headers:headers})
            .map(response => response.json())
            .map((response)=>{
                if(response.success){
                    localStorage.setItem('auth_token',response.auth_token);
                    localStorage.setItem("isLogin","true");
                }
            });
    }

    logout() {
        localStorage.removeItem('auth_token');
        localStorage.setItem('isLogin','false');
    }


}
