package com.example.lab5vaadin.data.repository;

import com.example.lab5vaadin.data.entity.Doctor;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Configuration
@Repository
public interface DoctorRepository extends CrudRepository<Doctor, Long> {
    List<Doctor> findAll();
}