import { Component } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-courses-form',
  templateUrl: './courses-form.component.html',
  styleUrls: ['./courses-form.component.scss'],
})
export class CoursesFormComponent {
  form: FormGroup;

  constructor(private formBuider: FormBuilder) {
    this.form = this.formBuider.group({
      name: [null],
      category: [null],
    });
  }

  onSubmit() {}
  onCancel() {}
}
