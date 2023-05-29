package com.example.lab5vaadin.data.service;

import com.example.lab5vaadin.data.entity.Patient;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.util.List;

@Configuration
@Service
public interface PatientService {
    List<Patient> getAllPatients();
    void savePatient(Patient patient);
    void deletePatientById(Long id);
    Patient getPatientById(Long id);
    void editPatient(Patient patient);
}
