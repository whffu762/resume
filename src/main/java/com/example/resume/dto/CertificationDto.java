package com.example.resume.dto;

import com.example.resume.entity.Certification;
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
public class CertificationDto {

    private Integer certificationId;
    @NotEmpty
    private String certification;
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$")
    @NotEmpty
    private String date;
    @NotEmpty
    private String association;

    public Certification convertEntity(){

        return Certification.builder()
                .certification(this.certification)
                .date(this.date)
                .association(this.association)
                .build();
    }
}
