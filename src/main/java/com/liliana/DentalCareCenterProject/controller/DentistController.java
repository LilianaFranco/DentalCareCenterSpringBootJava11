package com.liliana.DentalCareCenterProject.controller;

import com.liliana.DentalCareCenterProject.exception.ResourceNotFoundException;
import com.liliana.DentalCareCenterProject.model.DentistDto;
import com.liliana.DentalCareCenterProject.service.InterfaceDentistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/dentists")
public class DentistController {

    @Autowired
    InterfaceDentistService dentistService;

    @PostMapping
    public ResponseEntity<?> saveDentist(@RequestBody DentistDto dentistDto){
        dentistService.saveDentist(dentistDto);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public DentistDto getDentistById(@PathVariable Integer id) throws ResourceNotFoundException {
        return dentistService.getDentistById(id);
    }

    @PutMapping
    public ResponseEntity<?> updateDentist(@RequestBody DentistDto dentistDto){
        dentistService.updateDentist(dentistDto);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDentistById(@PathVariable Integer id){
        dentistService.deleteDentistById(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping
    public Collection<DentistDto> getDentistList(){
        return dentistService.getAllDentists();
    }


}
