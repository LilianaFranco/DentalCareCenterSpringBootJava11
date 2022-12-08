package com.liliana.DentalCareCenterProject.model;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Dentists")
public class Dentist {

    //Properties
    @Id
    @JsonProperty("dentistId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer dentistId;
    private int dentalLicense;
    private String lastName;
    private String name;

    @OneToMany(mappedBy = "dentist")
    @JsonIgnore
    private Set<Patient> patients;

    //Empty Constructor
    public Dentist() {
    }

    //Constructor
    public Dentist(Integer id, int dentalLicense, String lastName, String name) {
        this.dentistId = id;
        this.dentalLicense = dentalLicense;
        this.lastName = lastName;
        this.name = name;
    }

    //Getters and Setters
    public Integer getId() {
        return dentistId;
    }

    public void setId(Integer id) {
        this.dentistId = id;
    }

    public int getDentalLicense() {
        return dentalLicense;
    }

    public void setDentalLicense(int dentalLicense) {
        this.dentalLicense = dentalLicense;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //Methods
    @Override
    public String toString() {
        return "Dentist{" +
                "id=" + dentistId +
                ", dentalLicense=" + dentalLicense +
                ", lastName='" + lastName + '\'' +
                ", name='" + name + '\'' +
                '}';
    }


}
