import { Component, OnInit } from '@angular/core';
@Component({
  selector: 'app-site-list',
  templateUrl: './site-list.component.html',
  styleUrls: ['./site-list.component.css']
})
export class SiteListComponent implements OnInit {
  arrays = ['1','2','3','4'];
  constructor() {
    
   }

  ngOnInit() {
  }

}
