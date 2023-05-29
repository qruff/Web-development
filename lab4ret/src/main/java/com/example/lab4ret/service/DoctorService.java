package com.example.lab4ret.service;
import com.example.lab4ret.entity.Doctor;

import java.util.List;

public interface DoctorService {
    List<Doctor> getAllDoctors();
    void saveDoctor(Doctor doctor);
    void deleteDoctorById(Long id);
    Doctor getDoctorById(Long id);
    void editDoctor(Doctor doctor);
}
