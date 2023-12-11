package com.example.resume.dto;

import com.example.resume.entity.Education;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class EducationDto {

    private Integer educationId;
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}~\\d{4}-\\d{2}-\\d{2}$")
    @NotEmpty
    private String period;
    @NotEmpty
    private String school;
    @NotEmpty
    private String major;
    private String etc;

    public Education convertEntity(){

        return Education.builder()
                .period(this.period)
                .school(this.school)
                .major(this.major)
                .etc(this.etc)
                .build();
    }

}
