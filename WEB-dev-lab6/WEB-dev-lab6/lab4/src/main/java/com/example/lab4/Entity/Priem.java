package com.example.lab4.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "priem")
@NoArgsConstructor
public class Priem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial", insertable = false, updatable = false)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "doctor", nullable = true)
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name="patient")
    private Patient patient;

    @Column(name = "date")
    private Date date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setDate(String date){
        String[] datee= date.split("-");
        Date date_ = new Date();
        date_.setYear(Integer.parseInt(datee[0])-1900);
        date_.setMonth(Integer.parseInt(datee[1])-1);
        date_.setDate(Integer.parseInt(datee[2]));
        this.date = date_;

    }

}
