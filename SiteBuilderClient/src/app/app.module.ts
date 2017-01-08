import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { Routes, RouterModule }  from '@angular/router';
import { AppComponent } from './app.component';
import {AuthenticationService} from './authentication.service';
import {UserService} from './user.service';
import { HeaderComponent } from './header/header.component';
const appRoutes: Routes = [
  { path: '', component: HeaderComponent },
  
];

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    RouterModule.forRoot(appRoutes)
  ],  
  providers: [AuthenticationService, UserService],
  bootstrap: [AppComponent]
})
export class AppModule { }
