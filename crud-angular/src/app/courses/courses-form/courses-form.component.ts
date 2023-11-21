import { Component } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { CoursesService } from '../services/courses.service';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Location } from '@angular/common';

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
    private snackBar: MatSnackBar,
    private location: Location
  ) {
    this.form = this.formBuider.group({
      name: [null],
      category: [null],
    });
  }

  onSubmit() {
    this.service.save(this.form.value).subscribe(
      (result) => this.onSuccess(),
      (error) => this.onError()
    );
  }

  onCancel() {
    this.location.back();
  }

  private onSuccess() {
    this.snackBar.open('Curso salvo com sucesso', '', { duration: 2000 });
    this.onCancel();
  }

  private onError() {
    this.snackBar.open('Erro ao salvar curso', '', { duration: 2000 });
  }
}
