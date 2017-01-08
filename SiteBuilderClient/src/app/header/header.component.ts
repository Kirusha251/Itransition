import { Component, OnInit } from '@angular/core';
import {UserService} from  '../user.service';
import {AuthenticationService} from '../authentication.service';
import {Authentication} from '../authentication';
import {User} from '../User';
@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  isLogin = false;
  email: string;
  password: string;
  confirmPassword: string;
  userName:string;
  constructor(private UserService:UserService, private AuthenticationService:AuthenticationService) { 

  }

  ngOnInit() {

  }
  onLogoutButtonClick(){
    console.log("logout clicked");
    this.AuthenticationService.logout();
    this.isLogin = new Boolean(false).valueOf();
  }
  
  onSubmitButtonClick(){
      this.AuthenticationService.login(this.email,this.password)
      .subscribe((result: Authentication) => {
          if(new Boolean(result.isAuthenticate)){
            this.isLogin = true;
            console.log("login ok")
          }
          else{
            console.log('UserName or password is incorrect!');
          }
      });
  }
  onSaveButtonClick(){
    console.log(this.email, this.password, this.confirmPassword, this.userName);
    
  }
}
