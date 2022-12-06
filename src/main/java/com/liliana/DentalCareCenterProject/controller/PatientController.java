package com.liliana.DentalCareCenterProject.controller;
import com.liliana.DentalCareCenterProject.exception.ResourceNotFoundException;
import com.liliana.DentalCareCenterProject.model.PatientDto;
import com.liliana.DentalCareCenterProject.service.InterfacePatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    InterfacePatientService patientService;

    @PostMapping
    public ResponseEntity<?> savePatient(@RequestBody PatientDto patientDto){
        patientService.savePatient(patientDto);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public PatientDto getPatientById(@PathVariable Integer id) throws ResourceNotFoundException {
        return patientService.getPatientById(id);
    }

    @PutMapping
    public ResponseEntity<?> updatePatient(@RequestBody PatientDto patientDto){
        patientService.updatePatient(patientDto);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePatientById(@PathVariable Integer id){
        patientService.deletePatientById(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping
    public Collection<PatientDto> getPatientList(){
        return patientService.getAllPatients();
    }

}
