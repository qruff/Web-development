package com.example.lab4ret.entity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "priem")
@Data
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


    public void setDate(String date){
        String[] datee= date.split("-");
        Date date_ = new Date();
        date_.setYear(Integer.parseInt(datee[0])-1900);
        date_.setMonth(Integer.parseInt(datee[1])-1);
        date_.setDate(Integer.parseInt(datee[2]));
        this.date = date_;

    }
}
