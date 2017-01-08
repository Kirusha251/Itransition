import { Component, OnInit, Input} from '@angular/core';
import {Project} from '../Project';
@Component({
  selector: 'app-content',
  templateUrl: './content.component.html',
  styleUrls: ['./content.component.css'],
  inputs:['currentProject']
})
export class ContentComponent implements OnInit {
  currentProject:Project;
  
  content: String = "hello";

  constructor() { }
  
  ngOnInit() {
  
  }
  

}
