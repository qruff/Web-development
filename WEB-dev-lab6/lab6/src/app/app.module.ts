import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {ModalModule} from 'ngx-bootstrap/modal';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { DoctorsListComponent } from './doctors-list/doctors-list.component';
import {HttpClientModule} from "@angular/common/http";
import { DoctorsAddComponent } from './doctors-add/doctors-add.component';
import { FormsModule } from '@angular/forms';
import { DoctorsUpdComponent } from './doctors-upd/doctors-upd.component';
import { PatientListComponent } from './patient-list/patient-list.component';
import { PatientAddComponent } from './patient-add/patient-add.component';
import { PatientUpdComponent } from './patient-upd/patient-upd.component';
import { PriemUpdComponent } from './priem-upd/priem-upd.component';
import { PriemDoctorComponent } from './priem-doctor/priem-doctor.component';
import { PriemListComponent } from './priem-list/priem-list.component';
@NgModule({
  declarations: [
    AppComponent,
    NavBarComponent,
    DoctorsListComponent,
    DoctorsAddComponent,
    DoctorsUpdComponent,
    PatientListComponent,
    PatientAddComponent,
    PatientUpdComponent,
    PriemUpdComponent,
    PriemDoctorComponent,
    PriemListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ModalModule.forRoot()
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
