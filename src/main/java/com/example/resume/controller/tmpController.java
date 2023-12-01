package com.example.resume.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class tmpController {

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/")
    public String index(){
        return "test/html/index";
    }

    @GetMapping("/main")
    public String main(){
        return "main";
    }

    @GetMapping("/test")
    public String test(){
        return "test";
    }


}
