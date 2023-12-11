package com.example.resume.dto;


import com.example.resume.entity.PersonalInfo;
import jakarta.validation.GroupSequence;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.groups.Default;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PersonalInfoDto {

    private Integer resumeId;

    @Pattern(regexp = "^[가-힣]+$")
    @NotEmpty
    private String name;

    @Pattern(regexp = "[a-zA-Z]+$")
    @NotEmpty
    private String engName;

    @Pattern(regexp = "^\\d{6}-\\d{7}$")
    @NotEmpty
    private String residentNum;

    @Pattern(regexp = "^\\d{3}-\\d{4}-\\d{4}$")
    @NotEmpty
    private String tel;

    @Email
    @NotEmpty
    private String email;

    @NotEmpty
    private String address;

    public PersonalInfo convertEntity(){

        return PersonalInfo.builder()
                .engName(this.engName)
                .name(this.name)
                .residentNum(this.residentNum)
                .tel(this.tel)
                .email(this.email)
                .address(this.address)
                .build();
    }

}
