package com.liliana.DentalCareCenterProject.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.liliana.DentalCareCenterProject.exception.ResourceNotFoundException;
import com.liliana.DentalCareCenterProject.model.Dentist;
import com.liliana.DentalCareCenterProject.model.DentistDto;
import com.liliana.DentalCareCenterProject.model.Patient;
import com.liliana.DentalCareCenterProject.model.PatientDto;
import com.liliana.DentalCareCenterProject.repository.PatientRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PatientService implements InterfacePatientService {

    private static final Logger LOGGER = LogManager.getLogger();

    //Dependency Injection
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    ObjectMapper mapper;


    //Methods
    @Override
    public void savePatient(PatientDto patientDto) {
        //Convert patientDto to patient
        Patient patient = mapper.convertValue(patientDto, Patient.class);
        patientRepository.save(patient);
    }

    @Override
    public void deletePatientById(Integer patientId) {
        patientRepository.deleteById(patientId);

    }

    @Override
    public PatientDto getPatientById(Integer patientId) throws ResourceNotFoundException {
        Optional<Patient> patient = patientRepository.findById(patientId);
        //Create container
        PatientDto patientDto = null;
        //If it exists, convert to dentistDto
        if(patient.isEmpty()){
            LOGGER.error("Dentist not found");
            throw new ResourceNotFoundException("Dentist not found");
        }else{
            patientDto = mapper.convertValue(patient, PatientDto.class);
        }
        return patientDto;
    }

    @Override
    public void updatePatient(PatientDto patientDto) {
        //Reuse the save method.
        savePatient(patientDto);
    }

    @Override
    public Set<PatientDto> getAllPatients() {
        List<Patient> patients = patientRepository.findAll();
        //Create container to save a list of patientDto
        Set<PatientDto> patientDtos = new HashSet<>();
        //Convert patient into PatientDto to return the right list
        for(Patient patient: patients){
            patientDtos.add(mapper.convertValue(patient, PatientDto.class));
        }
        return patientDtos;
    }
}
