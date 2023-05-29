package com.example.lab5vaadin.data.service;

import com.example.lab5vaadin.data.entity.Doctor;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.util.List;
@Configuration
@Service
public interface DoctorService {
    List<Doctor> getAllDoctors();
    void saveDoctor(Doctor doctor);
    void deleteDoctorById(Long id);
    Doctor getDoctorById(Long id);
    void editDoctor(Doctor doctor);
}
