package com.liliana.DentalCareCenterProject.model;
import javax.persistence.*;

@Entity
@Table(name = "Dentists")
public class Dentist {

    //Properties
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private int dentalLicense;
    private String lastName;
    private String name;

    //Empty Constructor
    public Dentist() {
    }

    //Constructor
    public Dentist(Integer id, int dentalLicense, String lastName, String name) {
        this.id = id;
        this.dentalLicense = dentalLicense;
        this.lastName = lastName;
        this.name = name;
    }

    //Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
                "id=" + id +
                ", dentalLicense=" + dentalLicense +
                ", lastName='" + lastName + '\'' +
                ", name='" + name + '\'' +
                '}';
    }


}
