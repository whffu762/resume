package com.example.resume.service;

import com.example.resume.dto.CareerDto;
import com.example.resume.dto.PersonalInfoDto;
import com.example.resume.entity.Career;
import com.example.resume.repository.CareerRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CareerService {

    private final CareerRepository careerRepository;

    public List<CareerDto> getCareer(){
        return careerRepository.findAll().stream()
                .map(Career::convertDto)
                .toList();
    }

    public Boolean saveCareer(CareerDto input){

        try{
            careerRepository.save(input.convertEntity());
            return true;
        } catch(IllegalArgumentException e){
            return false;
        }
    }

    public void deleteCareer(Integer id){

        Career career = careerRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
        careerRepository.delete(career);
    }

}
