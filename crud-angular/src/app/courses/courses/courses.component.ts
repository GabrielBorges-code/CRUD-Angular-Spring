import { CoursesService } from './../services/courses.service';
import { Component, OnInit } from '@angular/core';
import { Courses } from '../model/courses';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-courses',
  templateUrl: './courses.component.html',
  styleUrls: ['./courses.component.scss'],
})
export class CoursesComponent implements OnInit {
  courses: Observable<Courses[]>;
  // courses: Courses[] = [];

  displayedColumns = ['name', 'category'];

  constructor(private coursesService: CoursesService) {
    this.courses = this.coursesService.list();
    // this.coursesService.list().subscribe((courses) => (this.courses = courses));
  }

  ngOnInit(): void {}
}
