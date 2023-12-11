package com.example.resume.controller;

import com.example.resume.dto.CareerDto;
import com.example.resume.service.CareerService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class CareerController {

    private final CareerService careerService;

    @PostMapping("/career")
    public ResponseEntity<String> inputCareer(@RequestBody @Validated CareerDto reqBody){

        if(!careerService.saveCareer(reqBody)){
            return ResponseEntity.badRequest().body("저장 실패");
        }
        return ResponseEntity.ok().body("저장 성공");
    }

    @DeleteMapping("/career")
    public ResponseEntity<String> deleteCareer(@RequestParam("id") Integer id){

        careerService.deleteCareer(id);
        return ResponseEntity.ok().body("삭제 성공");

    }

}
