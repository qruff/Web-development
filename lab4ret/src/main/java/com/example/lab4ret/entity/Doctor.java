package com.example.lab4ret.entity;
import lombok.*;
import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="doctor")
@NoArgsConstructor
@Data
public class Doctor {
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

    @Column(name = "type", nullable = false)
    private String type;

    @OneToMany(mappedBy = "doctor")
    private Set<Priem> priems = new HashSet<>();
    @Override
    public String toString(){return this.lastname + ' ' + this.firstname + ' ' + this.middlename;}
}
