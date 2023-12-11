package com.example.resume.controller;

import com.example.resume.dto.EducationDto;
import com.example.resume.service.EducationService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:5000")
public class EducationController {

    private final EducationService educationService;

    @PostMapping("/education")
    public ResponseEntity<String> inputEducation(@RequestBody @Validated EducationDto reqBody){

        if(!educationService.saveEducation(reqBody)){
            return ResponseEntity.badRequest().body("저장 실패");
        }
        return ResponseEntity.ok().body("저장 성공");
    }

    @DeleteMapping("/education")
    public ResponseEntity<String> deleteEducation(@RequestParam Integer id){

        educationService.deleteEducation(id);
        return ResponseEntity.ok().body("삭제 성공");
    }
}
