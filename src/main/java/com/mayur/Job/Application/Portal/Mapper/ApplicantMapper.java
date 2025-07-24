package com.mayur.Job.Application.Portal.Mapper;

import com.mayur.Job.Application.Portal.Dtos.ApplicantDto;
import com.mayur.Job.Application.Portal.Dtos.ApplicationDto;
import com.mayur.Job.Application.Portal.Model.Applicant;

import java.util.List;

public class ApplicantMapper {
    public static ApplicantDto toDto(Applicant applicant) {
        return new ApplicantDto(
                applicant.getApplicantId(),
                applicant.getFirstName(),
                applicant.getLastName(),
                applicant.getEmail(),
                applicant.getPhoneNumber(),
                applicant.getResumeUrl(),
                applicant.getLinkedinProfile(),
                applicant.getSkills(),
                applicant.getEducation(),
                applicant.getExperience(),
                applicant.getPortfolioUrl(),
                applicant.getApplications() != null ?
                        applicant.getApplications().stream().map(ApplicationMapper::toDto).toList() :
                        List.of()
        );
    }

    public static Applicant toEntity(ApplicantDto applicantDto) {
        Applicant applicant = new Applicant();
        applicant.setFirstName(applicantDto.getFirstName());
        applicant.setLastName(applicantDto.getLastName());
        applicant.setEmail(applicantDto.getEmail());
        applicant.setPhoneNumber(applicantDto.getPhoneNumber());
        applicant.setResumeUrl(applicantDto.getResumeUrl());
        applicant.setLinkedinProfile(applicantDto.getLinkedinProfile());
        applicant.setSkills(applicantDto.getSkills());
        applicant.setEducation(applicantDto.getEducation());
        applicant.setExperience(applicantDto.getExperience());
        applicant.setPortfolioUrl(applicantDto.getPortfolioUrl());
        return applicant;
    }
}
