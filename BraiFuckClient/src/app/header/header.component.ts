import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
   open: boolean;
  

  

  onToggle($event: Event) {
    $event.stopPropagation();
    this.open = true;
  }

  constructor() { }

  ngOnInit() {
  }

}
