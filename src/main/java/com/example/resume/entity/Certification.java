package com.example.resume.entity;

import com.example.resume.dto.CareerDto;
import com.example.resume.dto.CertificationDto;
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
public class Certification {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String certification;

    private String date;

    private String association;

    public CertificationDto convertDto(){
        return CertificationDto.builder()
                .certificationId(this.id)
                .certification(this.certification)
                .date(this.date)
                .association(this.association)
                .build();

    }
}
