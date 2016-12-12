import { Component, OnInit, } from '@angular/core';


@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  open: boolean;
  picks: any[] = [];

  items = [
    { value: 'Element 1', icon: 'BMW 1' },
    { value: 'Element 2', icon: 'BMW 2' },
    { value: 'Element 3', icon: 'BMW 3' },
    { value: 'Element 4', icon: 'BMW 4' },
  ];

  onToggle($event: Event) {
    $event.stopPropagation();
    this.open = true;
  }

  constructor() { }

  ngOnInit() {
  }

}
