package com.liliana.DentalCareCenterProject.model;

import java.util.Date;

public class PatientDto {
    //Properties
    private Integer patientId;
    private String lastName;
    private String name;
    private String address;
    private Date registrationDate;

    //Empty Constructor
    public PatientDto() {
    }

    //Constructor
    public PatientDto(Integer patientId, String lastName, String name, String address, Date registrationDate) {
        this.patientId = patientId;
        this.lastName = lastName;
        this.name = name;
        this.address = address;
        this.registrationDate = registrationDate;
    }

    //Getters and Setters
    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    //Methods
    @Override
    public String toString() {
        return "Patient{" +
                ", idCard=" + patientId +
                ", lastName='" + lastName + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", registrationDate=" + registrationDate +
                '}';
    }
}
