package com.example.resume.service;

import com.example.resume.dto.CareerDto;
import com.example.resume.dto.EducationDto;
import com.example.resume.entity.Education;
import com.example.resume.repository.EducationRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EducationService {

    private final EducationRepository educationRepository;

    public List<EducationDto> getEducation(){

        return educationRepository.findAll().stream()
                .map(Education::convertDto)
                .toList();
    }

    public Boolean saveEducation(EducationDto input){

        try{
            educationRepository.save(input.convertEntity());
            return true;
        } catch(DataIntegrityViolationException e){
            return false;
        }
    }

    public void deleteEducation(Integer id){

        Education education = educationRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);

        educationRepository.delete(education);
    }

}
