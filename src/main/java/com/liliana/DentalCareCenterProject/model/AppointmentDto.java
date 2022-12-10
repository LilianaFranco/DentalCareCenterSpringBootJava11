package com.liliana.DentalCareCenterProject.model;

import java.util.Date;

public class AppointmentDto {
    //Properties
    private Integer id;
    private Dentist dentist;
    private Patient patient;
    private Date date;

    //Empty Constructor
    public AppointmentDto() {
    }

    //Constructor
    public AppointmentDto(Integer appointmentId, Dentist dentist, Patient patient, Date date) {
        this.id = appointmentId;
        this.dentist = dentist;
        this.patient = patient;
        this.date = date;
    }

    //Getters and Setters

    public Integer getAppointmentId() {
        return id;
    }

    public void setAppointmentId(Integer appointmentId) {
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
                "appointmentId=" + id +
                ", dentist=" + dentist +
                ", patient=" + patient +
                ", date=" + date +
                '}';
    }
}
