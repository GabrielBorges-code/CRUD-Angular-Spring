import { Courses } from '../../model/courses';
import { Component, EventEmitter, Input, Output } from '@angular/core';

@Component({
  selector: 'app-courses-list',
  templateUrl: './courses-list.component.html',
  styleUrls: ['./courses-list.component.scss'],
})
export class CoursesListComponent {
  @Input() courses: Courses[] = [];
  @Output() add = new EventEmitter(false);

  readonly displayedColumns = ['name', 'category', 'actions'];

  constructor() {}

  onAdd() {
    this.add.emit(true);
  }
}
