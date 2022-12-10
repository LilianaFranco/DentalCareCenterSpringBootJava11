package com.liliana.DentalCareCenterProject.service;

import com.liliana.DentalCareCenterProject.exception.ResourceNotFoundException;
import com.liliana.DentalCareCenterProject.model.DentistDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class DentistServiceTest {

    @Autowired
    private InterfaceDentistService dentistService;

    @Test
    public void testSaveDentist() throws ResourceNotFoundException {

        //Given
        DentistDto dentistDto = new DentistDto();
        dentistDto.setDentalLicense(666);
        dentistDto.setLastName("Black");
        dentistDto.setLastName("Sirius");

        //When
        dentistService.saveDentist(dentistDto);
        DentistDto dentistSiriusBlack = dentistService.getDentistById(1);

        //Then
        assertTrue(dentistSiriusBlack!=null);

    }
}