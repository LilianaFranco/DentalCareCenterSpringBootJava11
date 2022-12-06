package com.liliana.DentalCareCenterProject.repository;

import com.liliana.DentalCareCenterProject.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
}
