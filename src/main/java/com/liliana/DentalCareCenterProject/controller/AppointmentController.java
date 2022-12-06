package com.liliana.DentalCareCenterProject.controller;
import com.liliana.DentalCareCenterProject.exception.ResourceNotFoundException;
import com.liliana.DentalCareCenterProject.model.AppointmentDto;
import com.liliana.DentalCareCenterProject.service.InterfaceAppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    InterfaceAppointmentService appointmentService;

    @PostMapping
    public ResponseEntity<?> saveAppointment(@RequestBody AppointmentDto appointmentDto){
        appointmentService.saveAppointment(appointmentDto);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public AppointmentDto getAppointmentById(@PathVariable Integer id) throws ResourceNotFoundException {
        return appointmentService.getAppointmentById(id);
    }

    @PutMapping
    public ResponseEntity<?> updateAppointment(@RequestBody AppointmentDto appointmentDto){
        appointmentService.updateAppointment(appointmentDto);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAppointmentById(@PathVariable Integer id){
        appointmentService.deleteAppointmentById(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping
    public Collection<AppointmentDto> getAppointmentList(){
        return appointmentService.getAllAppointments();
    }
}
