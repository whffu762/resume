package com.example.resume.service;

import com.example.resume.dto.CareerDto;
import com.example.resume.dto.CertificationDto;
import com.example.resume.entity.Certification;
import com.example.resume.repository.CertificationRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CertificationService {

    private final CertificationRepository certificationRepository;

    public List<CertificationDto> getCertification(){

        return certificationRepository.findAll().stream()
                .map(Certification::convertDto)
                .toList();
    }

    public Boolean saveCertification(CertificationDto input){

        try{
            certificationRepository.save(input.convertEntity());
            return true;
        } catch(IllegalArgumentException e){
            return false;
        }
    }

    public void deleteCertification(Integer id){

        Certification certification = certificationRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
        certificationRepository.delete(certification);
    }



}
