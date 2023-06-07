import { Component } from '@angular/core';
import { PatientService } from '../patient.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Patient } from '../class/patient';

@Component({
  selector: 'app-patient-upd',
  templateUrl: './patient-upd.component.html',
  styleUrls: ['./patient-upd.component.css']
})
export class PatientUpdComponent {
  box : Patient ;

  constructor(private boxServ : PatientService,private router: Router,private route: ActivatedRoute){
    this.box = new Patient();
  }
  onSubmit() {
    this.boxServ.update(this.box);
    this.gotoUserList();
  }
  ngOnInit() :void {
     this.boxServ.findById(this.route.snapshot.params['id']).subscribe(
      (responce) => {
        this.box = responce;
      }
     );


  }
  gotoUserList() {
    this.router.navigate(['/patients']);
  }
}
