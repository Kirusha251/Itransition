import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { Routes, RouterModule}  from '@angular/router';
import { AppComponent } from './app.component';
import {AuthenticationService} from './authentication.service';
import {UserService} from './user.service';
import { HeaderComponent } from './header/header.component';
import {TagCloudModule} from 'angular-tag-cloud-module';
import { TagCloudComponent } from './tag-cloud/tag-cloud.component';
import { MainPageComponent } from './main-page/main-page.component';
import { UserProfileComponent } from './user-profile/user-profile.component';
import { SiteListComponent } from './site-list/site-list.component';
const appRoutes: Routes = [
  { path: '', component: MainPageComponent },
  { path: 'UserProfile', component: UserProfileComponent, children:[
    { path: 'site-list', component: SiteListComponent, outlet:'user-profile' },
  ] },
  
  

  
];

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    TagCloudComponent,
    MainPageComponent,
    UserProfileComponent,
    SiteListComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
     RouterModule.forRoot(appRoutes),
    TagCloudModule
  ],  
  providers: [AuthenticationService, UserService],
  bootstrap: [AppComponent]
})
export class AppModule { }
