package com.liliana.DentalCareCenterProject.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Appointments")
public class Appointment {

    //Properties
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "dentist_id")
    private Dentist dentist;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "patient_id")
    private Patient patient;
    @Column
    private Date date;

    //Empty Constructor
    public Appointment() {
    }

    //Constructor
    public Appointment(Integer appointmentId, Dentist dentist, Patient patient, Date date) {
        this.id = appointmentId;
        this.dentist = dentist;
        this.patient = patient;
        this.date = date;
    }

    //Getters and Setters

    public int getAppointmentId() {
        return id;
    }

    public void setAppointmentId(int appointmentId) {
        this.id = appointmentId;
    }

    public Dentist getDentist() {
        return dentist;
    }

    public void setDentist(Dentist dentist) {
        this.dentist = dentist;
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

    //Methods

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", dentist=" + dentist +
                ", patient=" + patient +
                ", date=" + date +
                '}';
    }
}
