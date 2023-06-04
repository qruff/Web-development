import { Component } from '@angular/core';
import { PatientService } from '../patient.service';
import { Router } from '@angular/router';
import { Patient } from '../class/patient';

@Component({
  selector: 'app-patient-add',
  templateUrl: './patient-add.component.html',
  styleUrls: ['./patient-add.component.css']
})
export class PatientAddComponent {
  box : Patient = new Patient();
  constructor(private boxServ : PatientService,private router: Router){

  }

  onSubmit() {
    this.boxServ.save(this.box).subscribe(() => {
      this.gotoUserList();
    });
    //this.gotoUserList();
  }

  gotoUserList() {
    this.router.navigate(['/redirect_patient']);
  }
}
