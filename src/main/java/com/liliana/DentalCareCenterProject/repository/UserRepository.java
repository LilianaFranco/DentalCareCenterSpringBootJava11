package com.liliana.DentalCareCenterProject.repository;

import com.liliana.DentalCareCenterProject.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface UserRepository extends JpaRepository <AppUser, Integer> {
    Optional<AppUser> findByEmail(String email);
}
