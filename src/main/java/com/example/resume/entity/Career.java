package com.example.resume.entity;

import com.example.resume.dto.CareerDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Career {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String period;

    private String company;

    private String task;

    public CareerDto convertDto(){

        return CareerDto.builder()
                .careerId(this.id)
                .period(this.period)
                .company(this.company)
                .task(this.task)
                .build();

    }
}
