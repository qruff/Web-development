package com.example.lab5vaadin.data.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "patient")
@Data
@NoArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial", insertable = false, updatable = false)
    private Long id;

    @Column(name = "firstname", nullable = false)
    private String firstname;
    @Column(name = "lastname", nullable = false)
    private String lastname;
    @Column(name = "middlename", nullable = true)
    private String middlename;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "patient")
    private Set<Priem> priems = new HashSet<>();

    @Override
    public String toString(){return this.lastname + ' ' + this.firstname + ' ' + this.middlename;}

}
