package com.example.resume;

import com.example.resume.dto.CareerDto;
import com.example.resume.entity.Career;
import com.example.resume.repository.CareerRepository;
import com.example.resume.service.CareerService;
import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CareerServiceTest {

    private final CareerService careerService;

    CareerServiceTest(@Autowired CareerRepository careerRepository) {
        this.careerService = new CareerService(careerRepository);;
    }


    @Test
    public void test(){

        for(CareerDto career : careerService.getCareer()){
            System.out.println(career.getTask());
        }
    }
}
