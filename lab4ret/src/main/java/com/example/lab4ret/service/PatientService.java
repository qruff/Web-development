package com.example.lab4ret.service;

import com.example.lab4ret.entity.Patient;

import java.util.List;

public interface PatientService {
    List<Patient> getAllPatients();
    void savePatient(Patient patient);
    void deletePatientById(Long id);
    Patient getPatientById(Long id);
    void editPatient(Patient patient);
}
