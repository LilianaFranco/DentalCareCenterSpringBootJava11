package com.liliana.DentalCareCenterProject.repository;
import com.liliana.DentalCareCenterProject.model.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DentistRepository extends JpaRepository<Dentist, Integer> {
}
