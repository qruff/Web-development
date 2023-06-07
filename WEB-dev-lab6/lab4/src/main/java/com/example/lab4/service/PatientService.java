package com.example.lab4.service;

import com.example.lab4.Entity.Patient;

import java.util.List;

public interface PatientService {
   List<Patient> getAllPatient();
   void savePatient(Patient patient);
   void deletePatientById(Long id);
   Patient getPatientById(Long id);
   void editPatient(Patient patient);
}
