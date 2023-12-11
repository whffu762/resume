package com.example.resume.controller;

import com.example.resume.dto.PersonalInfoDto;
import com.example.resume.service.PersonalInfoService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
@Slf4j
@CrossOrigin(origins = "http://localhost:5000")
public class PersonalInfoController {

    private final PersonalInfoService personalInfoService;

    @PostMapping("/personal-info")
    public ResponseEntity<String> inputPersonalInfo(@RequestBody @Validated PersonalInfoDto reqBody){

        if(!personalInfoService.savePersonalInfo(reqBody)){
            return ResponseEntity.badRequest().body("저장 실패");
        }
        return ResponseEntity.ok().body("저장 성공");
    }

    @DeleteMapping("/personal-info")
    public ResponseEntity<String> deletePersonalInfo(@RequestParam Integer id){

        personalInfoService.deletePersonalInfo(id);
        return ResponseEntity.ok().body("삭제 성공");
    }
}
