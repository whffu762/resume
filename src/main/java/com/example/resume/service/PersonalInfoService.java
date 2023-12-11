package com.example.resume.service;

import com.example.resume.dto.PersonalInfoDto;
import com.example.resume.entity.PersonalInfo;
import com.example.resume.repository.PersonalInfoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class PersonalInfoService {

    private final PersonalInfoRepository personalInfoRepository;

    public PersonalInfoDto getPersonalInfo(){
        try{
            return personalInfoRepository.findById(1)
                    .orElseThrow(() -> new EntityNotFoundException("개인정보가 없습니다"))
                    .convertDto();
        } catch (EntityNotFoundException e){
            return new PersonalInfoDto();
        }
    }

    public Boolean savePersonalInfo(PersonalInfoDto input){

        try{
            personalInfoRepository.save(input.convertEntity());
            return true;
        } catch(IllegalArgumentException e){
            return false;
        }
    }

    public void deletePersonalInfo(Integer id){

        PersonalInfo personalInfo = personalInfoRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);

        personalInfoRepository.delete(personalInfo);

    }
}
