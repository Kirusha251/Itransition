import { Injectable } from '@angular/core';
import { Http, Headers, Response } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import { Authentication } from './Authentication';

@Injectable()
export class AuthenticationService {

  constructor(private http: Http) { }
   login(email: string, password: string) {
    let authenticate = new Authentication(email,password,false);
    let headers = new Headers();
    headers.append('Content-Type', 'application/json');
    console.log(JSON.stringify(authenticate));
    
        return this.http.post(' http://localhost:8080/authenticate', JSON.stringify(authenticate), {headers:headers})
            .map(response => response.json());
    }

    logout() {
        localStorage.removeItem('currentUser');
        localStorage.setItem('isLogin','false');
    }

}
