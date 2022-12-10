package com.liliana.DentalCareCenterProject.model;


public class DentistDto {

    //Properties
    private Integer id;
    private Integer dentalLicense;
    private String lastName;
    private String name;

    //Empty Constructor
    public DentistDto() {
    }

    //Constructor
    public DentistDto(int id, int dentalLicense, String lastName, String name) {
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

    public Integer getDentalLicense() {
        return dentalLicense;
    }

    public void setDentalLicense(Integer dentalLicense) {
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
