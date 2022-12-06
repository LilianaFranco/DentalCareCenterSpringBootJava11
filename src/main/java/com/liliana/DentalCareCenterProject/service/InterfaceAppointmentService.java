package com.liliana.DentalCareCenterProject.service;

import com.liliana.DentalCareCenterProject.exception.ResourceNotFoundException;
import com.liliana.DentalCareCenterProject.model.AppointmentDto;

import java.util.Set;

public interface InterfaceAppointmentService {
    void saveAppointment(AppointmentDto appointmentDto);
    void deleteAppointmentById(Integer appointmentId);
    AppointmentDto getAppointmentById(Integer appointmentId) throws ResourceNotFoundException;
    void updateAppointment(AppointmentDto appointmentDto);
    Set<AppointmentDto> getAllAppointments();
}
