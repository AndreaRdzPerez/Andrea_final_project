import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

declare interface RouteInfo {
  path: string;
  title: string;
  rtlTitle: string;
  icon: string;
  class: string;
}
export const ROUTES: RouteInfo[] = [
  {
    path: '/createTeam',
    title: 'Register Team',
    rtlTitle: 'لوحة القيادة',
    icon: 'icon-simple-add',
    class: '',
  },
  {
    path: '/teams',
    title: 'Teams',
    rtlTitle: 'إخطارات',
    icon: 'icon-chart-bar-32',
    class: '',
  },
  {
    path: '/matches',
    title: 'Matches',
    rtlTitle: 'الرموز',
    icon: 'icon-atom',
    class: '',
  },
  {
    path: '/referees',
    title: 'Referees',
    rtlTitle: 'خرائط',
    icon: 'icon-spaceship',
    class: '',
  },
];

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css']
})
export class SidebarComponent implements OnInit {
  menuItems: any[];
  isClicked = true;

  constructor(private router: Router) { }

  ngOnInit(): void {
    this.menuItems = ROUTES.filter((menuItem) => menuItem);
  }

  isMobileMenu() {
    if (window.innerWidth > 991) {
      return false;
    }
    return true;
  }

  navigate(url) {
    this.router.navigate([url]);
  }

}
