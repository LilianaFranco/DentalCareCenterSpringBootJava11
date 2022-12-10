package com.liliana.DentalCareCenterProject.service;

import com.liliana.DentalCareCenterProject.exception.ResourceNotFoundException;
import com.liliana.DentalCareCenterProject.model.PatientDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PatientServiceTest {

    @Autowired
    private InterfacePatientService patientService;

    @Test
    public void testSavePatient() throws ResourceNotFoundException {

        //Given
        PatientDto patientDto = new PatientDto();
        patientDto.setIdCard(987);
        patientDto.setLastName("Malfoy");
        patientDto.setLastName("Draco");
        patientDto.setAddress("Grimmauld Place");
        patientDto.setRegistrationDate(new Date());

        //When
        patientService.savePatient(patientDto);
        PatientDto patientDraco = patientService.getPatientById(1);

        //Then
        assertTrue(patientDraco!=null);

    }
}