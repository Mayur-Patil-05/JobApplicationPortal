package com.mayur.Job.Application.Portal.Service;

import com.mayur.Job.Application.Portal.Dtos.ApplicantDto;
import com.mayur.Job.Application.Portal.Exception.ApplicantNotFoundException;
import com.mayur.Job.Application.Portal.Mapper.ApplicantMapper;
import com.mayur.Job.Application.Portal.Model.Applicant;
import com.mayur.Job.Application.Portal.Repository.ApplicantRepository;
import com.mayur.Job.Application.Portal.Repository.ApplicationRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicantService {
    private final ApplicantRepository applicantRepository;


    @Autowired
    public ApplicantService(ApplicantRepository applicantRepository) {
        this.applicantRepository = applicantRepository;
    }

    public ApplicantDto addApplicant(ApplicantDto applicantDto) {
        Applicant applicant = ApplicantMapper.toEntity(applicantDto);
        Applicant savedApplicant = applicantRepository.save(applicant);
        return ApplicantMapper.toDto(savedApplicant);
    }

    public ApplicantDto getApplicantByID(Long applicantId) throws ApplicantNotFoundException {
        Applicant applicant = applicantRepository.findById(applicantId)
                .orElseThrow(() -> new ApplicantNotFoundException("Applicant not found"));
        return ApplicantMapper.toDto(applicant);
    }

    public List<ApplicantDto> getAllApplicant() {
        List<Applicant> applicants = applicantRepository.findAll();
        return applicants.stream().map(ApplicantMapper::toDto).toList();
    }

    @Transactional
    public ApplicantDto updateApplicant(Long applicantId, ApplicantDto applicantDto) throws ApplicantNotFoundException{
        Applicant applicant = applicantRepository.findById(applicantId)
                .orElseThrow(() -> new ApplicantNotFoundException("Applicant not found"));

        if (applicantDto.getFirstName() != null) {
            applicant.setFirstName(applicantDto.getFirstName());
        }
        if (applicantDto.getLastName() != null) {
            applicant.setLastName(applicantDto.getLastName());
        }
        if (applicantDto.getEmail() != null) {
            applicant.setEmail(applicantDto.getEmail());
        }
        if (applicantDto.getPhoneNumber() != null) {
            applicant.setPhoneNumber(applicantDto.getPhoneNumber());
        }
        if (applicantDto.getResumeUrl() != null) {
            applicant.setResumeUrl(applicantDto.getResumeUrl());
        }
        if (applicantDto.getLinkedinProfile() != null) {
            applicant.setLinkedinProfile(applicantDto.getLinkedinProfile());
        }
        if (applicantDto.getSkills() != null) {
            applicant.setSkills(applicantDto.getSkills());
        }
        if (applicantDto.getEducation() != null) {
            applicant.setEducation(applicantDto.getEducation());
        }
        if (applicantDto.getExperience() != null) {
            applicant.setExperience(applicantDto.getExperience());
        }
        if (applicantDto.getPortfolioUrl() != null) {
            applicant.setPortfolioUrl(applicantDto.getPortfolioUrl());
        }
        return ApplicantMapper.toDto(applicant);
    }

    public void deleteApplicant(Long applicantId) throws ApplicantNotFoundException{
        if (!applicantRepository.existsById(applicantId)){
            throw new ApplicantNotFoundException("Applicant not found");
        }
        applicantRepository.deleteById(applicantId);
    }
}
