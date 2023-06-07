import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { AppService } from '../app.service';
import { Router } from '@angular/router';
import { DoctorsAddComponent } from '../doctors-add/doctors-add.component';
import { BsModalService, BsModalRef, ModalOptions} from 'ngx-bootstrap/modal';
@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent {
  credentials = {username: '', password: ''};
  bsModalRef?: BsModalRef;
  constructor(private router: Router,public app: AppService, private http: HttpClient, private modalService: BsModalService) {
  }
  login(){
     this.app.authenticate(this.credentials);
     this.credentials.username = "";
     this.credentials.password = "";
  }
  openModal(){
    const modalOptions: ModalOptions = {
      initialState:{},
      class: 'modal-dialog-centered'
    }
    this.bsModalRef = this.modalService.show(DoctorsAddComponent);
  }
  logout(){
    this.app.authenticated = false;
    this.app.authAdmin = false;
    localStorage.setItem('role', String(0));
    localStorage.setItem('auth', String(0));
    this.router.navigate(['/']);
  }
}
