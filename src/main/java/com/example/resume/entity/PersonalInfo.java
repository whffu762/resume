package com.example.resume.entity;

import jakarta.persistence.*;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@Entity
public class Resume {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer resumeId;

    private String engName;

    private String name;

    private String birth;

    private String sex;

    private String age;

    private String tel;

    private String email;

    private String address;

}
