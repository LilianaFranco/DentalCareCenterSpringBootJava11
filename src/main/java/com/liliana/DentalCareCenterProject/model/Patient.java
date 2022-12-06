package com.liliana.DentalCareCenterProject.model;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Patients")
public class Patient {

    //Properties
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer patientId;
    private int idCard;
    private String lastName;
    private String name;
    private String address;
    private Date registrationDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dentistId", referencedColumnName = "dentistId")
    private Dentist dentist;

    //Empty Constructor
    public Patient() {
    }

    //Constructor
    public Patient(Integer id, int idCard, String lastName, String name, String address, Date registrationDate) {
        this.patientId = id;
        this.idCard = idCard;
        this.lastName = lastName;
        this.name = name;
        this.address = address;
        this.registrationDate = registrationDate;
    }

    //Getters and Setters
    public Integer getId() {
        return patientId;
    }

    public void setId(Integer id) {
        this.patientId = id;
    }

    public int getIdCard() {
        return idCard;
    }

    public void setIdCard(int idCard) {
        this.idCard = idCard;
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
                "id=" + patientId +
                ", idCard=" + idCard +
                ", lastName='" + lastName + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", registrationDate=" + registrationDate +
                '}';
    }
}
