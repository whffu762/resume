package com.example.resume.entity;

import com.example.resume.dto.PersonalInfoDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonalInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    private String engName;

    private String name;

    private String residentNum;

    private String tel;

    private String email;

    private String address;

    public PersonalInfoDto convertDto(){

        return PersonalInfoDto.builder()
                .resumeId(this.id)
                .engName(this.engName)
                .name(this.name)
                .residentNum(this.residentNum)
                .tel(this.tel)
                .email(this.email)
                .address(this.address)
                .build();
    }
}
