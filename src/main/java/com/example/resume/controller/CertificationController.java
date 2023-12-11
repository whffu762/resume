package com.example.resume.controller;

import com.example.resume.dto.CertificationDto;
import com.example.resume.entity.Certification;
import com.example.resume.repository.CertificationRepository;
import com.example.resume.service.CertificationService;
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
public class CertificationController {

    private final CertificationService certificationService;

    @PostMapping("/certification")
    public ResponseEntity<String> inputCertification(@RequestBody @Validated CertificationDto reqBody){

        if(!certificationService.saveCertification(reqBody)){
            return ResponseEntity.badRequest().body("저장 실패");
        }
        return ResponseEntity.ok().body("저장 성공");
    }

    @DeleteMapping("/certification")
    public ResponseEntity<String> deleteCertification(@RequestParam Integer id){

        certificationService.deleteCertification(id);
        return ResponseEntity.ok().body("삭제 성공");
    }
}
