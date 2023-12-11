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
    private String period;
    private String school;
    private String major;
    private String etc;
    public EducationDto convertDto(){

        return EducationDto.builder()
                .educationId(this.id)
                .period(this.period)
                .school(this.school)
                .major(this.major)
                .etc(this.etc)
                .build();

    }
}
