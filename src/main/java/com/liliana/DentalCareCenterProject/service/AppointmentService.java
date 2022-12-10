package com.liliana.DentalCareCenterProject.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.liliana.DentalCareCenterProject.exception.ResourceNotFoundException;
import com.liliana.DentalCareCenterProject.model.Appointment;
import com.liliana.DentalCareCenterProject.model.AppointmentDto;
import com.liliana.DentalCareCenterProject.repository.AppointmentRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class AppointmentService implements InterfaceAppointmentService{

    private static final Logger LOGGER = LogManager.getLogger();
    //Dependency Injection
    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    ObjectMapper mapper;

    //Methods
    @Override
    public void saveAppointment(AppointmentDto appointmentDto) {
        //Convert appointmentDto to appointment
        Appointment appointment = mapper.convertValue(appointmentDto, Appointment.class);
        appointmentRepository.save(appointment);
    }

    @Override
    public void deleteAppointmentById(Integer appointmentId) {
        appointmentRepository.deleteById(appointmentId);
    }

    @Transactional
    @Override
    public AppointmentDto getAppointmentById(Integer appointmentId) throws ResourceNotFoundException {
        Optional<Appointment> appointment = appointmentRepository.findById(appointmentId);
        //Create container
        AppointmentDto appointmentDto = null;
        //If it exists, convert to dentistDto
        if(appointment.isEmpty()){
            LOGGER.error("Dentist not found");
            throw new ResourceNotFoundException("Dentist not found");
        }else{
            appointmentDto = mapper.convertValue(appointment, AppointmentDto.class);
        }
        return appointmentDto;
    }

    @Override
    public void updateAppointment(AppointmentDto appointmentDto) {
        saveAppointment(appointmentDto);
    }

    @Transactional
    @Override
    public Set<AppointmentDto> getAllAppointments() {
        List<Appointment> appointments = appointmentRepository.findAll();
        //Create container to save a list of appointmentDto
        Set<AppointmentDto> appointmentDtos = new HashSet<>();
        //Convert appointments into AppointmentsDto to return the right list
        for(Appointment appointment: appointments){
            appointmentDtos.add(mapper.convertValue(appointment, AppointmentDto.class));
        }
        return appointmentDtos;
    }
}
