import { Component } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { CoursesService } from '../services/courses.service';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-courses-form',
  templateUrl: './courses-form.component.html',
  styleUrls: ['./courses-form.component.scss'],
})
export class CoursesFormComponent {
  form: FormGroup;

  constructor(
    private formBuider: FormBuilder,
    private service: CoursesService,
    private snackBar: MatSnackBar
  ) {
    this.form = this.formBuider.group({
      name: [null],
      category: [null],
    });
  }

  onSubmit() {
    this.service.save(this.form.value).subscribe(
      (result) => console.log('result', result),
      (error) => this.onError()
    );
  }

  onCancel() {
    console.log('cancel');
  }

  private onError() {
    this.snackBar.open('Erro ao salvar curso', '', { duration: 2000 });
  }
}
