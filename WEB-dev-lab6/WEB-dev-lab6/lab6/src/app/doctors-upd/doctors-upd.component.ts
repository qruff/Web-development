import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { DoctorServiceService } from '../doctor-service.service';
import { Doctor } from '../class/doctor';
import {BsModalRef}from 'ngx-bootstrap/modal';
@Component({
  selector: 'app-doctors-upd',
  templateUrl: './doctors-upd.component.html',
  styleUrls: ['./doctors-upd.component.css']
})
export class DoctorsUpdComponent {
  doctor : Doctor ;

  constructor(private carServ : DoctorServiceService,private router: Router,private route: ActivatedRoute, public bsModalRef:BsModalRef){
    this.doctor = new Doctor();
  }
  onSubmit() {
    this.ngOnInit();
    this.carServ.update(this.doctor);
    this.gotoUserList();
    
  }
  ngOnInit() :void {
     this.carServ.findById(this.route.snapshot.params['id']).subscribe(
      (responce) => {
        this.doctor = responce;
      }
     );


  }
  gotoUserList() {
    this.router.navigate(['/']);
  }
}
