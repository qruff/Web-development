package com.example.lab4.service;

import com.example.lab4.Entity.Doctor;

import java.util.List;

public interface DoctorService {
    List<Doctor> getAllDoctors();
    void saveDoctor(Doctor doctor);
    void deleteDoctorById(Long id);
    Doctor getDoctorById(Long id);
    void editDoctor(Doctor doctor);
}
