import { Component } from '@angular/core';
import { Courses } from '../model/courses';

@Component({
  selector: 'app-courses',
  templateUrl: './courses.component.html',
  styleUrls: ['./courses.component.scss'],
})
export class CoursesComponent {
  courses: Courses[] = [
    { _id: "0", name: 'Angular', category: 'Desenvolvimento' },
    { _id: "1", name: 'Bolsa de Valores', category: 'Investimentos' },
  ];
  displayedColumns = ['name', 'category'];

  constructor() {
    //   this.courses = [];
  }
}
