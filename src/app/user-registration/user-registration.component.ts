import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { RegisteruserService } from '../registeruser.service';
import{FormBuilder,FormGroup,Validators} from '@angular/forms';
import{HttpClientModule} from '@angular/common/http';
import{HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-user-registration',
  templateUrl: './user-registration.component.html',
  styleUrls: ['./user-registration.component.css']
})
export class UserRegistrationComponent implements OnInit {
  userForm: FormGroup= this.formBuilder.group({
    name: ['', Validators.required],
    email: ['', [Validators.required, Validators.email]],
    password: ['', Validators.required]
  });
  message: string='';

  constructor(private formBuilder: FormBuilder, private http: HttpClient) { }

  ngOnInit(){
   
  }
  userReg(){
   
    const user = this.userForm.value;
    console.log(user);
    this.http.post('http://localhost:8090/a/b', user)
      .subscribe({
        next: (data) => {
          this.message='User registered successfully';
          this.userForm.reset();
        },
        error: (error) => {
         this.message=error.error.message;
        }
      });
  }
  
  
}
