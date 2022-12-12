package com.liliana.DentalCareCenterProject.security;

import com.liliana.DentalCareCenterProject.model.AppUser;
import com.liliana.DentalCareCenterProject.model.AppUserRole;
import com.liliana.DentalCareCenterProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {
    private final UserRepository userRepository;

    @Autowired
    public DataLoader(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void run(ApplicationArguments args) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = passwordEncoder.encode("password");
        userRepository.save(new AppUser("Harry", "Harry", "harry@lili.com", password, AppUserRole.ADMIN));
    }
}
