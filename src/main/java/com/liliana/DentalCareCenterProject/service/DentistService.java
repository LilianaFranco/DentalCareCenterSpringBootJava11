package com.liliana.DentalCareCenterProject.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.liliana.DentalCareCenterProject.exception.ResourceNotFoundException;
import com.liliana.DentalCareCenterProject.model.Dentist;
import com.liliana.DentalCareCenterProject.model.DentistDto;
import com.liliana.DentalCareCenterProject.repository.DentistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class DentistService implements InterfaceDentistService{

    //Dependency Injection
    @Autowired
    private DentistRepository dentistRepository;

    @Autowired
    ObjectMapper mapper;

    //Methods
    @Override
    public void saveDentist(DentistDto dentistDto) {
        Dentist dentist = mapper.convertValue(dentistDto, Dentist.class);
        dentistRepository.save(dentist);
    }

    @Override
    public void deleteDentistById(Integer dentistId) {
        dentistRepository.deleteById(dentistId);
    }

    @Override
    public DentistDto getDentistById(Integer dentistId) throws ResourceNotFoundException {
        Optional<Dentist> dentist = dentistRepository.findById(dentistId);
        //Create container
        DentistDto dentistDto = null;
        //If it exists, convert to dentistDto
        if(dentist.isEmpty()){
            throw new ResourceNotFoundException("Dentist not found");
        }else{
            dentistDto = mapper.convertValue(dentist, DentistDto.class);
        }
        return dentistDto;
    }

    @Override
    public void updateDentist(DentistDto dentistDto) {
        saveDentist(dentistDto);
    }

    @Override
    public Set<DentistDto> getAllDentists() {
        List<Dentist> dentists = dentistRepository.findAll();
        //Create container to save a list of dentistDto
        Set<DentistDto> dentistDtos = new HashSet<>();
        //Convert dentist into DentistDto to return the right list
        for(Dentist dentist: dentists){
            dentistDtos.add(mapper.convertValue(dentist, DentistDto.class));
        }
        return dentistDtos;
    }
}
