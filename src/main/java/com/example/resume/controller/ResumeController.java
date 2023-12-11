package com.example.resume.controller;

import com.example.resume.dto.*;
import com.example.resume.service.ResumeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
@AllArgsConstructor
public class ResumeController {

    private final ResumeService resumeService;

    @GetMapping(value = "/resumes", produces = "application/json")
    public ResponseEntity<ResumeDto> resumes(){

        return ResponseEntity.ok().body(resumeService.getResume());
    }
}
