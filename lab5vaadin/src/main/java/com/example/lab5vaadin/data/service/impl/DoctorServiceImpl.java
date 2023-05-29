package com.example.lab5vaadin.data.service.impl;

import com.example.lab5vaadin.data.entity.Doctor;
import com.example.lab5vaadin.data.repository.DoctorRepository;
import com.example.lab5vaadin.data.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {
    private final DoctorRepository doctorRepository;

    @Autowired
    public DoctorServiceImpl(DoctorRepository doctorRepository) {
        super();
        this.doctorRepository = doctorRepository;
    }

    @Override
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    @Override
    public void saveDoctor(Doctor doctor) {
        doctorRepository.save(doctor);
    }

    @Override
    public void deleteDoctorById(Long id) {
        doctorRepository.deleteById(id);
    }

    @Override
    public Doctor getDoctorById(Long id) {
        return doctorRepository.findById(id).get();
    }

    @Override
    public void editDoctor(Doctor doctor) {
        doctorRepository.save(doctor);
    }
}
