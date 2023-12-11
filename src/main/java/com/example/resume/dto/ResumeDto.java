package com.example.resume.dto;


import lombok.*;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ResumeDto {

    PersonalInfoDto personalInfoDto;

    List<EducationDto> educationDto;

    List<CertificationDto> certificationDto;

    List<CareerDto> careerDto;
}
