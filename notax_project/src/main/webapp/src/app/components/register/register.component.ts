import { Component } from '@angular/core';
import { MaterialModule } from 'src/app/material/material.module';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss'],
  providers: [MaterialModule],
})
export class RegisterComponent {
  registerText = {
    title: "Lets Grades do the hard work for you.",
    fullname: "Type your full name",
    email: "Type your email",
    password: "Type your password",
    submit: "All right"
  };

  placeholder = {
    email: "Your email",
    fullname: "Your name",
    password: "Your password"
  }

  form = {
    fullname: "",
    email: "",
    password: ""
  }

  onSubmit() {
  }

}
