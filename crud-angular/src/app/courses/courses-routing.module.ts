import { CoursesComponent } from './containers/courses/courses.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CoursesFormComponent } from './containers/courses-form/courses-form.component';

const routes: Routes = [
  {
    path: '',
    component: CoursesComponent,
  },
  {
    path: 'new',
    component: CoursesFormComponent,
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class CoursesRoutingModule {}
