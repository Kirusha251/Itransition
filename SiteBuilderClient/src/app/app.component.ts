import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
   cloudData = [
    {text: 'Weight-9', weight: 9, link: 'https://domain.com', external: true, color: '#ffaaee'},
    {text: 'Weight-7', weight: 7, link: 'https://domain.com', color: 'green'},
    {text: 'Weight-7', weight: 7, link: 'https://domain.com', external: true},
    {text: 'Weight-5', weight: 5, link: 'https://domain.com', color: 'black'},
    {text: 'Weight-1', weight: 1, link: 'https://domain.com', color: 'black'}
  ]
}
