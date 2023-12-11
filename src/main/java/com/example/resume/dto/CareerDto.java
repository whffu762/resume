package com.example.resume.dto;

import com.example.resume.entity.Career;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class CareerDto {

    private Integer careerId;
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2} ~ \\d{4}-\\d{2}-\\d{2}$")
    @NotEmpty
    private String period;
    @NotEmpty
    private String company;
    @NotEmpty
    private String task;

    public Career convertEntity(){

        return Career.builder()
                .period(this.period)
                .company(this.company)
                .task(this.task)
                .build();
    }
}
