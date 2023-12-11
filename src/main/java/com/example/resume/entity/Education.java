package com.example.resume.entity;

import com.example.resume.dto.EducationDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String startPeriod;

    private String endPeriod;

    private String school;

    private String major;

    private String etc;
    public EducationDto convertDto(){

        return EducationDto.builder()
                .educationId(this.id)
                .startPeriod(this.startPeriod)
                .endPeriod(this.endPeriod)
                .school(this.school)
                .major(this.major)
                .etc(this.etc)
                .build();

    }
}
