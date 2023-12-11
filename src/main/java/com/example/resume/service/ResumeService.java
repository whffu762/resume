package com.example.resume.service;


import com.example.resume.dto.ResumeDto;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ResumeService {

    private final PersonalInfoService personalInfoService;
    private final CareerService careerService;
    private final CertificationService certificationService;
    private final EducationService educationService;

    public ResumeDto getResume(){

        return ResumeDto.builder()
                .personalInfoDto(personalInfoService.getPersonalInfo())
                .careerDto(careerService.getCareer())
                .certificationDto(certificationService.getCertification())
                .educationDto(educationService.getEducation())
                .build();
    }
}
